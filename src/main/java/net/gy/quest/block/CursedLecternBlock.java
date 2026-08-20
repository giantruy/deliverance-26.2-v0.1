package net.gy.quest.block;

import net.gy.quest.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.List;
import java.util.Map;

public class CursedLecternBlock extends Block {

    private static final VoxelShape SHAPE_COLLISION = Shapes.or(
            Block.column(16.0, 0.0, 2.0),
            Block.column(8.0, 2.0, 14.0)
    );

    private static final Map<Direction, VoxelShape> SHAPES = Shapes.rotateHorizontal(
            Shapes.or(
                    Block.boxZ(16.0, 10.0, 14.0, 1.0, 5.333333),
                    Block.boxZ(16.0, 12.0, 16.0, 5.333333, 9.666667),
                    Block.boxZ(16.0, 14.0, 18.0, 9.666667, 14.0),
                    SHAPE_COLLISION
            )
    );

    public static final EnumProperty<Direction> FACING = HorizontalDirectionalBlock.FACING;

    private static final int RADIUS = 32;

    public CursedLecternBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPES.get(state.getValue(FACING));
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE_COLLISION;
    }

    @Override
    public InteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (level.isClientSide()) return InteractionResult.SUCCESS;

        ServerLevel serverLevel = (ServerLevel) level;
        boolean isRunestone = stack.is(ModItems.RUNESTONE);
        boolean isPolished = stack.is(ModItems.POLISHED_RUNESTONE);

        if (!isRunestone && !isPolished) return InteractionResult.PASS;

        int amplifier = isPolished ? 1 : 0;
        int duration = isPolished ? 3 * 60 * 20 : 5 * 60 * 20;

        AABB area = new AABB(pos).inflate(RADIUS);
        List<LivingEntity> targets = serverLevel.getEntitiesOfClass(LivingEntity.class, area,
                entity -> !(entity instanceof Player p && p.getUUID().equals(player.getUUID()))
        );

        for (LivingEntity target : targets) {
            MobEffectInstance existing = target.getEffect(MobEffects.WEAKNESS);
            int existingDuration = existing != null && existing.getAmplifier() == amplifier
                    ? existing.getDuration()
                    : 0;
            target.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, existingDuration + duration, amplifier, false, true, true));
        }

        stack.shrink(1);
        return InteractionResult.SUCCESS;
    }
}