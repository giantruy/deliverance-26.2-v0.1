package net.gy.quest.item;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.gy.quest.Deliverance;
import net.gy.quest.block.ModBlocks;
import net.gy.quest.datagen.ModJukeboxSongs;
import net.gy.quest.entity.ModEntityTypes;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.network.Filterable;
import net.minecraft.util.Unit;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.component.ItemLore;
import net.minecraft.world.item.component.WrittenBookContent;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.ItemEnchantments;

import java.util.List;
import java.util.function.Function;

public class ModItems{

    public static final Consumable NOTCH_APPLE_CONSUMABLE = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    List.of(
                            new MobEffectInstance(MobEffects.ABSORPTION, 60 * 20, 4, false, false, false),
                            new MobEffectInstance(MobEffects.REGENERATION, 15 * 20, 2, false, false, false),
                            new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 240 * 20, 0, false, false, false),
                            new MobEffectInstance(MobEffects.RESISTANCE, 240 * 20, 2, false, false, false),
//                            new MobEffectInstance(MobEffects.STRENGTH, 15 * 20, 2, false, false, false),
//                            new MobEffectInstance(MobEffects.SPEED, 120 * 20, 1, false, false, false),
//                            new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 60 * 20, 1, false, false, false),
//                            new MobEffectInstance(MobEffects.HASTE, 120 * 20, 2, false, false, false),
                            new MobEffectInstance(MobEffects.NIGHT_VISION, 120 * 20, 0, false, false, false),
                            new MobEffectInstance(MobEffects.INVISIBILITY, 30 * 20, 0, false, false, false)
                    )
            )).build();



    public static final Item NOTCH_CORE = registerItem("kings_apple_core",
            properties -> new Item(properties.rarity(Rarity.EPIC).stacksTo(1)
                    .component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true)));

    public static final Item NOTCH_APPLE = registerItem("kings_apple",
            properties -> new NotchAppleItem(properties.rarity(Rarity.EPIC).fireResistant().food(
                    new FoodProperties.Builder()
                            .nutrition(6)
                            .saturationModifier(6)
                            .alwaysEdible()
                            .build())
                    .stacksTo(1)
                    .component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true)
                    .component(DataComponents.CONSUMABLE, NOTCH_APPLE_CONSUMABLE)
                    .component(DataComponents.LORE, new ItemLore(List.of(
                            Component.literal("The food of kings")))),
                    ModItems.NOTCH_CORE
            ));

    public static final Item ANCIENT_WOLF_FANG = registerItem("ancient_wolf_fang",
            properties -> new Item(properties.rarity(Rarity.RARE).stacksTo(4)
                    .component(DataComponents.LORE, new ItemLore(List.of(
                            Component.literal("A fang of an ancient wolf species"))))));

//    public static final Item COPPER_CORE = registerItem("copper_core",
//            properties -> new Item(properties.rarity(Rarity.UNCOMMON)));
//    public static final Item IRON_CORE = registerItem("iron_core",
//            properties -> new Item(properties.rarity(Rarity.UNCOMMON)));
//    public static final Item GOLD_CORE = registerItem("gold_core",
//            properties -> new Item(properties.rarity(Rarity.UNCOMMON)));
//    public static final Item DIAMOND_CORE = registerItem("diamond_core",
//            properties -> new Item(properties.rarity(Rarity.UNCOMMON)));
//    public static final Item NETHERITE_CORE = registerItem("netherite_core",
//            properties -> new Item(properties.rarity(Rarity.RARE)));
//    public static final Item SPIDER_CORE = registerItem("spider_core",
//            properties -> new Item(properties.rarity(Rarity.UNCOMMON)));
    public static final Item CURSED_BOOK = registerItem("cursed_book",
            properties -> new Item(properties.rarity(Rarity.RARE)
                    .component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true)));
    public static final Item RUNESTONE = registerItem("runestone",
            properties -> new Item(properties.rarity(Rarity.UNCOMMON)));
    public static final Item POLISHED_RUNESTONE = registerItem("polished_runestone",
            properties -> new Item(properties.rarity(Rarity.UNCOMMON)));

    public static final Item RUNESTONE_SWORD = registerItem("runestone_sword",
            properties -> new Item(properties.sword(ModToolMaterials.RUNESTONE_TOOL_MATERIAL,
                    4f, -2.4f)));
    public static final Item RUNESTONE_PICKAXE = registerItem("runestone_pickaxe",
            properties -> new Item(properties.pickaxe(ModToolMaterials.RUNESTONE_TOOL_MATERIAL,
                    1.5f, -2.8f)));
    public static final Item RUNESTONE_AXE = registerItem("runestone_axe",
            properties -> new Item(properties.axe(ModToolMaterials.RUNESTONE_TOOL_MATERIAL,
                    7f, -3.0f)));
    public static final Item RUNESTONE_SHOVEL = registerItem("runestone_shovel",
            properties -> new Item(properties.shovel(ModToolMaterials.RUNESTONE_TOOL_MATERIAL,
                    2f, -3.0f)));
    public static final Item RUNESTONE_HOE = registerItem("runestone_hoe",
            properties -> new Item(properties.hoe(ModToolMaterials.RUNESTONE_TOOL_MATERIAL,
                    -2.5f, -3.0f)));
    public static final Item RUNESTONE_SPEAR = registerItem("runestone_spear",
            properties -> new Item(properties.spear(ModToolMaterials.RUNESTONE_TOOL_MATERIAL,
                    1.1F, 1.1F, 0.45F, 2.75F, 9.5F, 6F, 5.1F, 9.375F, 4.6F)));

    public static final Item RUNESTONE_UPGRADE_SMITHING_TEMPLATE = registerItem(
            "runestone_upgrade_smithing_template");


    public static final WrittenBookContent STORY_CONTENT = new WrittenBookContent(
            Filterable.passThrough("The Great Partition"),
            "Harald",
            0,
            List.of(
                    Filterable.passThrough(Component.literal("")
                            .append(Component.literal("The Great Partition").withStyle(ChatFormatting.BOLD).withStyle(ChatFormatting.UNDERLINE))
                            .append(Component.literal("\n\nIn the age before names were given, four beings walked the world:\n"))
                            .append(Component.literal("Staffan").withStyle(ChatFormatting.OBFUSCATED).withStyle(ChatFormatting.AQUA)).append(Component.literal(",\n"))
                            .append(Component.literal("Sandra").withStyle(ChatFormatting.OBFUSCATED).withStyle(ChatFormatting.GREEN)).append(Component.literal(",\n"))
                            .append(Component.literal("Harald Bane").withStyle(ChatFormatting.OBFUSCATED).withStyle(ChatFormatting.RED)).append(Component.literal(", and\n"))
                            .append(Component.literal("Mark Canute").withStyle(ChatFormatting.OBFUSCATED).withStyle(ChatFormatting.BLUE)).append(Component.literal("."))
                    ),
                    Filterable.passThrough(Component.literal("Each held power beyond mortal reckoning. Together, they shaped the mountains, dug riverbeds, set the seeds into the soil, and breathed life into the world.")),
                    Filterable.passThrough(Component.literal("For a long age they worked as one, and the world flourished under their hands.")),

                    Filterable.passThrough(Component.literal("But power does not rest easy in every heart. ")
                            .append(Component.literal("Harald Bane").withStyle(ChatFormatting.OBFUSCATED).withStyle(ChatFormatting.BLUE))
                            .append(Component.literal(" grew hungry for more than his share. He looked upon the others work, and saw weaknesses to be claimed."))),
                    Filterable.passThrough(Component.literal("In secret he gathered strength and built an army, twisting the land where he walked, until the day he turned against his kin.")),

                    Filterable.passThrough(Component.literal("The battle that followed split mountains and boiled rivers. ")
                            .append(Component.literal("Staffan").withStyle(ChatFormatting.OBFUSCATED).withStyle(ChatFormatting.AQUA)).append(Component.literal(", "))
                            .append(Component.literal("Sandra").withStyle(ChatFormatting.OBFUSCATED).withStyle(ChatFormatting.GREEN)).append(Component.literal(", and "))
                            .append(Component.literal("Mark Canute").withStyle(ChatFormatting.OBFUSCATED).withStyle(ChatFormatting.RED)).append(Component.literal(" stood together, while "))
                            .append(Component.literal("Harald Bane").withStyle(ChatFormatting.OBFUSCATED).withStyle(ChatFormatting.BLUE)).append(Component.literal(" stood alone."))),

                    Filterable.passThrough(Component.literal("The battle lasted weeks. Though his army was strong and power vast, it could not match the bond between them. When the dust finally settled, he was beaten but not destroyed.")),
                    Filterable.passThrough(Component.literal("So the three of them did what none wished to do. They tore his power from him and bound it, splitting it three ways.")),
                    Filterable.passThrough(Component.literal("Into the ")
                            .append(Component.literal("Unbreakable Pickaxe").withStyle(ChatFormatting.OBFUSCATED).withStyle(ChatFormatting.DARK_AQUA)).append(Component.literal(" they poured his wrath. Into the "))
                            .append(Component.literal("Cursed Lectern").withStyle(ChatFormatting.OBFUSCATED).withStyle(ChatFormatting.GOLD)).append(Component.literal(" they bound his magic, and "))
                            .append(Component.literal("Blood Dropper").withStyle(ChatFormatting.OBFUSCATED).withStyle(ChatFormatting.DARK_RED)).append(Component.literal(" they sealed his cunning."))
                    ),

                    Filterable.passThrough(Component.literal("Each object was cast into a far corner of the world, hidden from one another, guarded by trial and distance alike.")),
                    Filterable.passThrough(Component.literal("")
                            .append(Component.literal("Harald Bane").withStyle(ChatFormatting.OBFUSCATED).withStyle(ChatFormatting.BLUE))
                            .append(Component.literal(" himself they cast out beyond the edge of all things, into exile, stripped of strength to return."))),

                    Filterable.passThrough(Component.literal("Heartbroken, ")
                            .append(Component.literal("Staffan").withStyle(ChatFormatting.OBFUSCATED).withStyle(ChatFormatting.AQUA)).append(Component.literal(", "))
                            .append(Component.literal("Sandra").withStyle(ChatFormatting.OBFUSCATED).withStyle(ChatFormatting.GREEN)).append(Component.literal(", and "))
                            .append(Component.literal("Mark Canute").withStyle(ChatFormatting.OBFUSCATED).withStyle(ChatFormatting.RED)).append(Component.literal(" never spoke of his name again. Some say they feared it would call him back. Others say they could not bear to."))),
                    Filterable.passThrough(Component.literal("In time, even they scattered. Realizing the destructive potential of themselves, they too bound their powers into three objects each, so that if that item were to be crafted again, it would be infused with their power.")),
                    Filterable.passThrough(Component.literal("Legend has it that ")
                            .append(Component.literal("Harald Bane").withStyle(ChatFormatting.OBFUSCATED).withStyle(ChatFormatting.BLUE))
                            .append(Component.literal(" is still out there, along with the other three fragments of his power, waiting one day to be gathered and delivered back to their original wielder.")))
            ),
            true
    );

    public static final Item STORY_BOOK = registerItem("story_book", properties -> new WrittenBookItem(properties
            .stacksTo(1)
            .component(DataComponents.WRITTEN_BOOK_CONTENT, STORY_CONTENT)
            .rarity(Rarity.UNCOMMON)
            .component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true)));

public static final Item UNBREAKABLE_PICKAXE = registerItem("unbreakable_pickaxe",
            properties -> new UnbreakablePickaxe(properties.pickaxe(ToolMaterial.NETHERITE,
                            3.5f, -2.5f)
                    .component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true)
                    .component(DataComponents.UNBREAKABLE, Unit.INSTANCE)
                    .rarity(Rarity.EPIC)
                    .useCooldown(1)
                    .component(DataComponents.LORE, new ItemLore(List.of(
                            Component.literal("The electrifying pickaxe of ")
                                    .append(Component.literal("Harald Bane").withStyle(ChatFormatting.OBFUSCATED, ChatFormatting.DARK_AQUA))
                    )))
    ));

public static final Item HOLY_SWORD = registerItem("holy_sword",
            properties -> new HolySword(properties.sword(ToolMaterial.NETHERITE,
                            4.5f, -2.4f)
                    .component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true)
                    .component(DataComponents.UNBREAKABLE, Unit.INSTANCE)
                    .delayedComponent(DataComponents.ENCHANTMENTS, context -> {
                        Holder<Enchantment> smite = context.getOrThrow(Enchantments.SMITE);
                        ItemEnchantments.Mutable mutable = new ItemEnchantments.Mutable(ItemEnchantments.EMPTY);
                        mutable.set(smite, 7);
                        return mutable.toImmutable();
                    })
                    .rarity(Rarity.EPIC)
                    .useCooldown(2)
                    .component(DataComponents.LORE, new ItemLore(List.of(
                            Component.literal("The holy burning sword of ")
                                    .append(Component.literal("Mark Canute").withStyle(ChatFormatting.OBFUSCATED, ChatFormatting.RED))
                    )))
    ));

    public static final RedstoneHammer REDSTONE_HAMMER = (RedstoneHammer) registerItem("redstone_hammer",
            properties -> new RedstoneHammer(properties.sword(ToolMaterial.NETHERITE,
                            4.5f, -2.4f)
                    .component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true)
                    .component(DataComponents.UNBREAKABLE, Unit.INSTANCE)
                    .delayedComponent(DataComponents.ENCHANTMENTS, context -> {
                        Holder<Enchantment> knockback = context.getOrThrow(Enchantments.KNOCKBACK);
                        Holder<Enchantment> unbreaking = context.getOrThrow(Enchantments.UNBREAKING);
                        Holder<Enchantment> mending = context.getOrThrow(Enchantments.MENDING);
                        ItemEnchantments.Mutable mutable = new ItemEnchantments.Mutable(ItemEnchantments.EMPTY);
                        mutable.set(mending, 1);
                        mutable.set(knockback, 4);
                        mutable.set(unbreaking, 5);
                        return mutable.toImmutable();
                    })
                    .rarity(Rarity.EPIC)
                    .useCooldown(2)
                    .component(DataComponents.LORE, new ItemLore(List.of(
                            Component.literal("The raw pummeling power of ")
                                    .append(Component.literal("Staffan").withStyle(ChatFormatting.OBFUSCATED, ChatFormatting.AQUA))
                    )))
            ));

    public static final Item WOLF_FANG_TRIDENT = registerItem("wolf_fang_trident",
            properties -> new WolfTrident(properties
                    .delayedComponent(DataComponents.ENCHANTMENTS, context -> {
                        Holder<Enchantment> loyalty = context.getOrThrow(Enchantments.LOYALTY);
                        ItemEnchantments.Mutable mutable = new ItemEnchantments.Mutable(ItemEnchantments.EMPTY);
                        mutable.set(loyalty, 5);
                        return mutable.toImmutable();
                    })
                    .component(DataComponents.UNBREAKABLE, Unit.INSTANCE)
                    .rarity(Rarity.EPIC)
                    .component(DataComponents.LORE, new ItemLore(List.of(
                            Component.literal("The loyal wolf trident of ")
                                    .append(Component.literal("Sandra").withStyle(ChatFormatting.OBFUSCATED, ChatFormatting.GREEN))
                    )))
    ));

    public static final Item MUSIC_DISC_DOWNED = registerItem("music_disc_downed", properties -> new Item(properties.rarity(Rarity.UNCOMMON).stacksTo(1).jukeboxPlayable(ModJukeboxSongs.DOWNED_KEY)));

    public static final Item WHISTLE = registerItem("whistle", properties -> new WhistleItem(properties.rarity(Rarity.UNCOMMON).stacksTo(1).useCooldown(20)));

    public static final RiftKey RIFT_KEY = (RiftKey) registerItem("rift_key", properties -> new RiftKey(properties.rarity(Rarity.EPIC).stacksTo(1)
            .component(DataComponents.LORE, new ItemLore(List.of(
            Component.literal("When used, this key will crate a rift to")
                    .append(Component.literal("Harald Bane").withStyle(ChatFormatting.OBFUSCATED, ChatFormatting.BLUE)))))));

    public static final Item SAVAGE_SPAWN_EGG = registerItem("savage_spawn_egg", properties -> new SpawnEggItem(properties.spawnEgg(ModEntityTypes.SAVAGE)));

    public static final Item SHATTERGUARD_SPAWN_EGG = registerItem("shatterguard_spawn_egg", properties -> new SpawnEggItem(properties.spawnEgg(ModEntityTypes.SHATTERGUARD)));


    public static final Item CLASSIC_OAK_SAPLING = Registry.register(
            BuiltInRegistries.ITEM,
            Identifier.fromNamespaceAndPath(Deliverance.MOD_ID, "classic_oak_sapling"),
            new BlockItem(ModBlocks.CLASSIC_OAK_SAPLING,
                    new Item.Properties()
                            .useBlockDescriptionPrefix()
                            .setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Deliverance.MOD_ID, "classic_oak_sapling")))
                            .food(new FoodProperties.Builder()
                                    .nutrition(2)
                                    .saturationModifier(0.3f)
                                    .build()
                            )
            )
    );

    public static final Item BLOOD_DROPPER = registerItem("blood_dropper", properties -> new BloodDropper(properties.rarity(Rarity.UNCOMMON).stacksTo(1).useCooldown(20)));






    private static Item registerItem(String name, Function<Item.Properties, Item> function) {
        return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(Deliverance.MOD_ID, name),
                function.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Deliverance.MOD_ID, name)))));
    }

    private static Item registerItem(String name) {
        return registerItem(name, Item::new);
    }

    public static void registerModItems() {
        Deliverance.LOGGER.info("Registering Mod Items for " + Deliverance.MOD_ID);

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(output-> {
//            output.accept(COPPER_CORE);
//            output.accept(IRON_CORE);
//            output.accept(GOLD_CORE);
//            output.accept(DIAMOND_CORE);
//            output.accept(NETHERITE_CORE);
//            output.accept(SPIDER_CORE);
            output.accept(CURSED_BOOK);
            output.accept(RUNESTONE);
            output.accept(POLISHED_RUNESTONE);
            output.accept(RUNESTONE_UPGRADE_SMITHING_TEMPLATE);
            output.accept(ANCIENT_WOLF_FANG);
        });

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT).register(output-> {
            output.accept(RUNESTONE_SWORD);
            output.accept(RUNESTONE_SPEAR);
            output.accept(UNBREAKABLE_PICKAXE);
            output.accept(HOLY_SWORD);
            output.accept(WOLF_FANG_TRIDENT);
            output.accept(REDSTONE_HAMMER);
        });

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(output-> {
            output.accept(RUNESTONE_PICKAXE);
            output.accept(RUNESTONE_AXE);
            output.accept(RUNESTONE_SHOVEL);
            output.accept(RUNESTONE_HOE);
            output.accept(STORY_BOOK);
            output.accept(UNBREAKABLE_PICKAXE);
            output.accept(WHISTLE);
            output.accept(BLOOD_DROPPER);
        });

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.FOOD_AND_DRINKS).register(output-> {
            output.accept(NOTCH_CORE);
            output.accept(NOTCH_APPLE);
            output.accept(CLASSIC_OAK_SAPLING);
        });

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.SPAWN_EGGS).register(output-> {
            output.accept(SAVAGE_SPAWN_EGG);
            output.accept(SHATTERGUARD_SPAWN_EGG);
        });

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(output-> {
            output.accept(MUSIC_DISC_DOWNED);
        });

    }
}
