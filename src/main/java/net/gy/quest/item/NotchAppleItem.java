package net.gy.quest.item;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.level.Level;

public class NotchAppleItem extends Item {
    private final Item resultItem;

    public NotchAppleItem(Properties properties, Item resultItem) {
        super(properties);
        this.resultItem = resultItem;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        ItemStack result = super.finishUsingItem(stack, level, entity);

        if (entity instanceof Player player && !player.hasInfiniteMaterials()) {
            ItemStack converted = new ItemStack(resultItem);
            if (result.isEmpty()) {
                return converted;
            } else {
                if (!player.getInventory().add(converted)) {
                    player.drop(converted, false);
                }
                return result;
            }
        }
        return result;

    }
}
