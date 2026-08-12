package net.gy.quest.block.entity;

import net.gy.quest.menu.StaffansCrafterMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.world.Container;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.network.chat.Component;
import org.jspecify.annotations.Nullable;


public class StaffansCrafterBlockEntity extends BlockEntity implements MenuProvider {

    private final SimpleContainer inventory = new SimpleContainer(10);

    public float rotation;

    public StaffansCrafterBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.STAFFANS_CRAFTER_BE, pos, state);
    }

    public Container getContainer() {
        return inventory;
    }

    public SimpleContainer getInventory() {
        return inventory;
    }

    public void craft() {
        if (level == null || level.isClientSide()) return;
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.quest.staffans_crafter");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int containerId, Inventory playerInventory, Player player) {
        return new StaffansCrafterMenu(containerId, playerInventory, inventory, this);
    }


    public static void bookAnimationTick(Level level, BlockPos pos, BlockState state, StaffansCrafterBlockEntity blockEntity) {
        if (level.isClientSide()) {
            blockEntity.rotation += 0.03F;
            if (blockEntity.rotation >= (float) (Math.PI * 2)) {
                blockEntity.rotation -= (float) (Math.PI * 2);
            }
        }
    }

}
