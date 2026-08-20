package net.gy.quest.block;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.gy.quest.Deliverance;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.references.BlockIds;
import net.minecraft.references.BlockItemIds;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import java.util.function.Function;

import static net.minecraft.world.level.block.Blocks.flowerPotProperties;

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

    public static final Block CLASSIC_GRASS = registerBlock("classic_grass",
            properties -> new ClassicGrassBlock(properties.mapColor(MapColor.COLOR_LIGHT_GREEN)
                    .strength(0.6F).sound(SoundType.GRASS)
            ));

    public static final Block CLASSIC_DIRT = registerBlock("classic_dirt",
            properties -> new Block(properties.mapColor(MapColor.DIRT)
                    .strength(0.5F).sound(SoundType.GRAVEL)
            ));

    public static final Block CLASSIC_STONE = registerBlock("classic_stone",
            properties -> new Block(properties.mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.5F, 6.0F))
            );

    public static final Block CLASSIC_COBBLESTONE = registerBlock("classic_cobblestone",
            properties -> new Block(properties.mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F))
    );

    public static final Block CLASSIC_OAK_LOG = registerBlock("classic_oak_log",
            properties -> new RotatedPillarBlock(properties.mapColor(MapColor.WOOD).sound(SoundType.WOOD).ignitedByLava().strength(2.0F))
    );

    public static final Block CLASSIC_OAK_PLANKS = registerBlock(
            "classic_oak_planks",
            properties ->  new Block(properties.mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava())
    );

    public static final Block CLASSIC_CRAFTING_TABLE = registerBlock("classic_crafting_table",
            properties -> new Block(properties.mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.WOOD).ignitedByLava()));

    public static final Block CLASSIC_BRICKS = registerBlock("classic_bricks",
            properties -> new Block(properties.mapColor(MapColor.COLOR_RED).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F))
    );

    public static final Block CLASSIC_OAK_LEAVES = registerBlock("classic_oak_leaves", properties -> new TintedParticleLeavesBlock(0.0F, properties.mapColor(MapColor.PLANT)
            .strength(0.2F)
            .randomTicks()
            .sound(SoundType.GRASS)
            .noOcclusion()
            .isValidSpawn(Blocks::ocelotOrParrot)
            .isSuffocating(Blocks::never)
            .isViewBlocking(Blocks::never)
            .ignitedByLava()
            .pushReaction(PushReaction.DESTROY)
            .isRedstoneConductor(Blocks::never)));

    public static final Block CLASSIC_OAK_SAPLING = (SaplingBlock) registerBlockNoItem("classic_oak_sapling", properties ->
            new SaplingBlock(ModTreeGrowers.CLASSIC_OAK, properties.mapColor(MapColor.PLANT).noCollision().randomTicks().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY)));

    public static final Block POTTED_CLASSIC_OAK_SAPLING = registerBlock("potted_classic_oak_sapling", properties -> new FlowerPotBlock(CLASSIC_OAK_SAPLING, properties.instabreak().noOcclusion().pushReaction(PushReaction.DESTROY)));


    public static final Block CLASSIC_BEDROCK = registerBlock(
            "classic_bedrock",
            properties -> new Block(properties.mapColor(MapColor.STONE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .strength(-1.0F, 3600000.0F)
                    .noLootTable()
                    .isValidSpawn(Blocks::never))
    );

    public static final CursedLecternBlock CURSED_LECTERN = (CursedLecternBlock) registerBlock(
            "cursed_lectern",
            properties -> new CursedLecternBlock(properties.mapColor(MapColor.WOOD).strength(2.5F, 3600000.0F)
                    .isValidSpawn(Blocks::never))
    );


    private static Block registerBlockNoItem(String name, Function<BlockBehaviour.Properties, Block> function) {
        Block toRegister = function.apply(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Deliverance.MOD_ID, name))));
        return Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(Deliverance.MOD_ID, name), toRegister);
    }

    private static Block registerBlock(String name, Function<BlockBehaviour.Properties, Block> function) {
        Block toRegister = function.apply(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Deliverance.MOD_ID, name))));
        registerBlockItem(name, toRegister);
        return Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(Deliverance.MOD_ID, name), toRegister);
    }

//    private static CraftingTableBlock registerClassicCraftingTableBlock(String name, Function<BlockBehaviour.Properties, CraftingTableBlock> function) {
//        CraftingTableBlock toRegister = function.apply(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Deliverance.MOD_ID, name))));
//        registerBlockItem(name, toRegister);
//        return Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(Deliverance.MOD_ID, name), toRegister);
//    }

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
                    output.accept(CLASSIC_GRASS);
                    output.accept(CLASSIC_DIRT);
                    output.accept(CLASSIC_STONE);
                    output.accept(CLASSIC_COBBLESTONE);
                    output.accept(CLASSIC_OAK_LOG);
                    output.accept(CLASSIC_OAK_PLANKS);
                }
        );

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.NATURAL_BLOCKS).register(output-> {
                    output.accept(RUNESTONE_ORE);
                    output.accept(CLASSIC_GRASS);
                    output.accept(CLASSIC_DIRT);
                    output.accept(CLASSIC_STONE);
                    output.accept(CLASSIC_COBBLESTONE);
                    output.accept(CLASSIC_OAK_LOG);
                    output.accept(CLASSIC_OAK_PLANKS);
                    output.accept(CLASSIC_CRAFTING_TABLE);
                    output.accept(CLASSIC_OAK_LEAVES);
                    output.accept(CLASSIC_OAK_SAPLING);
                }
        );

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.FUNCTIONAL_BLOCKS).register(output-> {
                    output.accept(STAFFANS_CRAFTER);
//                    output.accept(CLASSIC_CRAFTING_TABLE);
                    output.accept(CURSED_LECTERN);
                }
        );

    }

}
