package net.gy.quest.creativemodetab;

import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.gy.quest.Deliverance;
import net.gy.quest.block.ModBlocks;
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
//                        output.accept(ModItems.COPPER_CORE);
//                        output.accept(ModItems.IRON_CORE);
//                        output.accept(ModItems.GOLD_CORE);
//                        output.accept(ModItems.DIAMOND_CORE);
//                        output.accept(ModItems.NETHERITE_CORE);
//                        output.accept(ModItems.SPIDER_CORE);
                        output.accept(ModItems.CURSED_BOOK);
                        output.accept(ModItems.RUNESTONE);
                        output.accept(ModItems.POLISHED_RUNESTONE);
                        output.accept(ModBlocks.RUNESTONE_ORE);
                        output.accept(ModBlocks.RUNESTONE_BLOCK);
                        output.accept(ModBlocks.POLISHED_RUNESTONE_BLOCK);
                        output.accept(ModBlocks.ANCIENT_STONE_BRICKS);
                        output.accept(ModBlocks.STAFFANS_CRAFTER);
                        output.accept(ModItems.RUNESTONE_SWORD);
                        output.accept(ModItems.RUNESTONE_PICKAXE);
                        output.accept(ModItems.RUNESTONE_AXE);
                        output.accept(ModItems.RUNESTONE_SHOVEL);
                        output.accept(ModItems.RUNESTONE_HOE);
                        output.accept(ModItems.RUNESTONE_SPEAR);
                        output.accept(ModItems.RUNESTONE_UPGRADE_SMITHING_TEMPLATE);
                        output.accept(ModItems.STORY_BOOK);
                        output.accept(ModItems.UNBREAKABLE_PICKAXE);
                        output.accept(ModItems.NOTCH_CORE);
                        output.accept(ModItems.NOTCH_APPLE);
                        output.accept(ModItems.HOLY_SWORD);
                        output.accept(ModItems.SAVAGE_SPAWN_EGG);
                        output.accept(ModItems.SHATTERGUARD_SPAWN_EGG);
                        output.accept(ModItems.ANCIENT_WOLF_FANG);
                        output.accept(ModItems.MUSIC_DISC_DOWNED);
                        output.accept(ModItems.WOLF_FANG_TRIDENT);
                        output.accept(ModItems.WHISTLE);
                        output.accept(ModBlocks.CLASSIC_GRASS);
                        output.accept(ModBlocks.CLASSIC_DIRT);
                        output.accept(ModBlocks.CLASSIC_STONE);
                        output.accept(ModBlocks.CLASSIC_COBBLESTONE);
                        output.accept(ModBlocks.CLASSIC_OAK_LOG);
                        output.accept(ModBlocks.CLASSIC_OAK_PLANKS);
                        output.accept(ModBlocks.CLASSIC_CRAFTING_TABLE);
                        output.accept(ModBlocks.CLASSIC_BRICKS);
                        output.accept(ModItems.CLASSIC_OAK_SAPLING);
                        output.accept(ModBlocks.CLASSIC_BEDROCK);
                        output.accept(ModItems.RIFT_KEY);
                        output.accept(ModItems.BLOOD_DROPPER);
                        output.accept(ModBlocks.CURSED_LECTERN);
                    }).build());


    public static void registerModCreativeModeTabs() {
        Deliverance.LOGGER.info("Registering Creative Mod Tabs for " + Deliverance.MOD_ID);
    }
}
