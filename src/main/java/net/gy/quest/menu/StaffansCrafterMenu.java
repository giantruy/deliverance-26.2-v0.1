package net.gy.quest.menu;

import net.gy.quest.block.entity.StaffansCrafterBlockEntity;
import net.gy.quest.recipe.ModRecipes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingInput;

public class StaffansCrafterMenu extends AbstractContainerMenu {

    private final Container container;
    private final BlockPos pos;
    private final Player player;

    public StaffansCrafterMenu(int containerId, Inventory playerInventory) {
        this(containerId, playerInventory, new SimpleContainer(10), null);
    }

    public StaffansCrafterMenu(int containerId, Inventory playerInventory, Container container, StaffansCrafterBlockEntity entity) {

        super(ModMenuTypes.STAFFANS_CRAFTER_MENU, containerId);
        this.container = container;
        this.player = playerInventory.player;
        this.pos = entity != null ? entity.getBlockPos() : BlockPos.ZERO;

        for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    int index = row * 3 + col;
                    addSlot(new Slot(container, index, 30 + col * 18, 17 + row * 18) {
                        @Override
                        public void setChanged() {
                            super.setChanged();
                            updateResult();
                        }
                    });
                }
        }

        addSlot(new Slot(container, RESULT_SLOT,124, 35) {
            @Override
            public boolean mayPlace(ItemStack stack) {
                return false;
            }

            @Override
            public void onTake(Player player, ItemStack stack) {
                super.onTake(player, stack);
                consumeIngredients();
            }
        });

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 9; col++) {
                this.addSlot(new Slot(playerInventory, col + row * 9 + 9, 8 + col * 18, 84 + row * 18));
            }
        }

        for (int col = 0; col < 9; col++) {
            this.addSlot(new Slot(playerInventory, col, 8 + col * 18, 142));
        }

    }

//    @Override
//    public void slotsChanged(Container container) {
//        super.slotsChanged(container);
//        if (container == this.container) {
//            updateResult();
//        }
//    }

    private void updateResult() {
//        System.out.println("Updating result");


        if (!(container instanceof SimpleContainer simple)) {
            return;
        }

        CraftingInput input = CraftingInput.of(3, 3, simple.getItems().subList(0, 9));

        if (player.level().getServer() == null) {
            return;
        }

        var recipe = player.level().getServer().getRecipeManager().getRecipeFor(ModRecipes.STAFFANS_CRAFTING_TYPE, input, player.level());

        if (recipe.isPresent()) {
            container.setItem(RESULT_SLOT,recipe.get().value().assemble(input));
        } else {
            container.setItem(RESULT_SLOT, ItemStack.EMPTY);
        }


    }


    private void consumeIngredients() {
        for (int i = 0; i< 9; i++) {
            container.removeItem(i, 1);
        }
        updateResult();
    }

    private static final int GRID_START = 0;
    private static final int GRID_END = 9;

    private static final int RESULT_SLOT = 9;

    private static final int INV_START = 10;
    private static final int INV_END = 37;

    private static  final int HOTBAR_START = 37;
    private static final int HOTBAR_END = 46;

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);

        if (slot != null && slot.hasItem()) {
            ItemStack slotStack = slot.getItem();
            newStack = slotStack.copy();


            if (index == RESULT_SLOT) {
                if (!this.moveItemStackTo(slotStack, INV_START, HOTBAR_END, true)) {
                    return ItemStack.EMPTY;
                }
                consumeIngredients();
                return newStack;
            } else if (index < GRID_END) {
                if (!this.moveItemStackTo(slotStack, INV_START, HOTBAR_END, true)) {
                    return ItemStack.EMPTY;
                }
            } else if (index >= INV_START && index < HOTBAR_END) {
                if (!this.moveItemStackTo(slotStack, GRID_START, GRID_END, false)) {
                    return ItemStack.EMPTY;
                }
            } else {
                return ItemStack.EMPTY;
            }

            if (slotStack.isEmpty()) {
                slot.setByPlayer(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
        }

        return newStack;
    }

    @Override
    public boolean stillValid(Player player) {
        return this.pos != BlockPos.ZERO && player.level().getBlockEntity(this.pos) != null
                && player.distanceToSqr(
                        this.pos.getX() + 0.5, this.pos.getY() + 0.5, this.pos.getZ() + 0.5)
                <= 64.0;
    }

    @Override
    public void removed(Player player) {
        super.removed(player);
        for (int i = 0; i < 9; i++) {
            ItemStack stack = this.container.removeItemNoUpdate(i);

            if (!stack.isEmpty()) {
                player.getInventory().placeItemBackInInventory(stack);
            }
        }
    }

}
