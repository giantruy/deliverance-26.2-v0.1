package net.gy.quest.block;

import net.gy.quest.block.entity.ModBlockEntities;
import net.gy.quest.block.entity.StaffansCrafterBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jspecify.annotations.Nullable;

public class StaffansCrafterBlock extends Block implements EntityBlock {

    private static final VoxelShape SHAPE = Block.column(16.0, 0.0, 12.0);

    public StaffansCrafterBlock(Properties properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new StaffansCrafterBlockEntity(pos, state);
    }

    @Override
    public InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult result) {
        if (!level.isClientSide()) {
            BlockEntity be = level.getBlockEntity(pos);
            if (be instanceof StaffansCrafterBlockEntity crafter) {
                player.openMenu(crafter);
            }
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    public void playerDestroy(Level level, Player player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack destroyedWith) {
        if (blockEntity instanceof StaffansCrafterBlockEntity crafter) {
            Containers.dropContents(level, pos, crafter.getContainer());
        }
        super.playerDestroy(level, player, pos, state, blockEntity, destroyedWith);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        if (type ==ModBlockEntities.STAFFANS_CRAFTER_BE) {
            return (lvl, pos, st, be) -> StaffansCrafterBlockEntity.bookAnimationTick(lvl, pos, st, (StaffansCrafterBlockEntity)be);
        }
        return null;
    }


}
