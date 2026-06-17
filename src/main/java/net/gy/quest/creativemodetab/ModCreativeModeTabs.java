package net.gy.quest.creativemodetab;

import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.gy.quest.Deliverance;
import net.gy.quest.item.ModItems;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTabs {
    public static final CreativeModeTab MOD_ITEM_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(Deliverance.MOD_ID, "deliverance_items"),
            FabricCreativeModeTab.builder().icon(() -> new ItemStack(ModItems.CURSED_BOOK))
                    .title(Component.translatable("creativemodetab.quest.deliverance_items"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.COPPER_CORE);
                        output.accept(ModItems.IRON_CORE);
                        output.accept(ModItems.GOLD_CORE);
                        output.accept(ModItems.DIAMOND_CORE);
                        output.accept(ModItems.NETHERITE_CORE);
                        output.accept(ModItems.SPIDER_CORE);
                        output.accept(ModItems.CURSED_BOOK);
                    }).build());


    public static void registerModCreativeModeTabs() {
        Deliverance.LOGGER.info("Registering Creative Mod Tabs for " + Deliverance.MOD_ID);
    }
}
