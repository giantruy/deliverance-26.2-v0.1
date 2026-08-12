package net.gy.quest.block;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.gy.quest.Deliverance;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.dedicated.Settings;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;

import java.util.function.Function;

public class ModBlocks {

    public static final Block ANCIENT_STONE_BRICKS = registerBlock("ancient_stone_bricks",
            properties -> new Block(properties.mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops().strength(0.5F, 2.0F).sound(SoundType.STONE)
            ));
    public static final StaffansCrafterBlock STAFFANS_CRAFTER = registerCraftingBlock("staffans_crafter",
            properties -> new StaffansCrafterBlock(properties.mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASS)
                    .requiresCorrectToolForDrops().strength(1.0F, 5.0F).sound(SoundType.ANCIENT_DEBRIS)
            ));

    public static final Block RUNESTONE_ORE = registerBlock("runestone_ore",
            properties -> new Block(properties.mapColor(MapColor.COLOR_YELLOW).instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops().strength(4.5F, 6.0F).sound(SoundType.ANCIENT_DEBRIS)
            ));
    public static final Block RUNESTONE_BLOCK = registerBlock("runestone_block",
            properties -> new Block(properties.mapColor(MapColor.COLOR_BLUE).instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops().strength(4.5F, 6.0F).sound(SoundType.ANCIENT_DEBRIS)
            ));
    public static final Block POLISHED_RUNESTONE_BLOCK = registerBlock("polished_runestone_block",
            properties -> new Block(properties.mapColor(MapColor.COLOR_BLUE).instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops().strength(4.5F, 6.0F).sound(SoundType.ANCIENT_DEBRIS)
            ));

    private static Block registerBlock(String name, Function<BlockBehaviour.Properties, Block> function) {
        Block toRegister = function.apply(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Deliverance.MOD_ID, name))));
        registerBlockItem(name, toRegister);
        return Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(Deliverance.MOD_ID, name), toRegister);
    }

    private static StaffansCrafterBlock registerCraftingBlock(String name, Function<BlockBehaviour.Properties, StaffansCrafterBlock> function) {
        StaffansCrafterBlock toRegister = function.apply(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Deliverance.MOD_ID, name))));
        registerBlockItem(name, toRegister);
        return Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(Deliverance.MOD_ID, name), toRegister);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(Deliverance.MOD_ID, name),
                new BlockItem(block, new Item.Properties().useBlockDescriptionPrefix()
                        .setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Deliverance.MOD_ID, name)))));
    }

    public static ResourceKey<Block> getRK(Block block) {
        return BuiltInRegistries.BLOCK.getResourceKey(block).get();
    }


    public static void registerModBlocks() {
        Deliverance.LOGGER.info("Registering Mod Blocks for " + Deliverance.MOD_ID);

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS).register(output-> {
                    output.accept(ANCIENT_STONE_BRICKS);
                    output.accept(RUNESTONE_BLOCK);
                    output.accept(POLISHED_RUNESTONE_BLOCK);
                }
        );

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.NATURAL_BLOCKS).register(output-> {
                    output.accept(RUNESTONE_ORE);
                }
        );

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.FUNCTIONAL_BLOCKS).register(output-> {
                    output.accept(STAFFANS_CRAFTER);
                }
        );

    }

}
