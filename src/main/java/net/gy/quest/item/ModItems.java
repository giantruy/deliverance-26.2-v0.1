package net.gy.quest.item;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.gy.quest.Deliverance;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.network.Filterable;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.WrittenBookItem;
import net.minecraft.world.item.component.WrittenBookContent;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.function.Function;

public class ModItems{


    public static final Item COPPER_CORE = registerItem("copper_core",
            properties -> new Item(properties.rarity(Rarity.UNCOMMON)));
    public static final Item IRON_CORE = registerItem("iron_core",
            properties -> new Item(properties.rarity(Rarity.UNCOMMON)));
    public static final Item GOLD_CORE = registerItem("gold_core",
            properties -> new Item(properties.rarity(Rarity.UNCOMMON)));
    public static final Item DIAMOND_CORE = registerItem("diamond_core",
            properties -> new Item(properties.rarity(Rarity.UNCOMMON)));
    public static final Item NETHERITE_CORE = registerItem("netherite_core",
            properties -> new Item(properties.rarity(Rarity.RARE)));
    public static final Item SPIDER_CORE = registerItem("spider_core",
            properties -> new Item(properties.rarity(Rarity.UNCOMMON)));
    public static final Item CURSED_BOOK = registerItem("cursed_book",
            properties -> new Item(properties.rarity(Rarity.RARE)));
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

                    Filterable.passThrough(Component.literal("")
                            .append(Component.literal("Staffan").withStyle(ChatFormatting.OBFUSCATED).withStyle(ChatFormatting.AQUA)).append(Component.literal(", "))
                            .append(Component.literal("Sandra").withStyle(ChatFormatting.OBFUSCATED).withStyle(ChatFormatting.GREEN)).append(Component.literal(", and "))
                            .append(Component.literal("Mark Canute").withStyle(ChatFormatting.OBFUSCATED).withStyle(ChatFormatting.RED)).append(Component.literal(" never spoke of his name again. Some say they feared it would call him back. Others say they could not bear to."))),
                    Filterable.passThrough(Component.literal("In time, even they scattered. Realizing the destructive potential of themselves, they too bound their powers into three objects each, leaving behind the world they had shaped.")),
                    Filterable.passThrough(Component.literal("Legend has it that ")
                            .append(Component.literal("Harald Bane").withStyle(ChatFormatting.OBFUSCATED).withStyle(ChatFormatting.BLUE))
                            .append(Component.literal(" is still out there, along with the other three fragments of his power, waiting one day to be gathered and delivered back to their original wielder.")))
            ),
            true
    );

    public static final Item STORY_BOOK = registerItem("story_book", properties -> new WrittenBookItem(properties
            .stacksTo(1)
            .component(DataComponents.WRITTEN_BOOK_CONTENT, STORY_CONTENT)
            .rarity(Rarity.EPIC)
            .component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true)));


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
            output.accept(COPPER_CORE);
            output.accept(IRON_CORE);
            output.accept(GOLD_CORE);
            output.accept(DIAMOND_CORE);
            output.accept(NETHERITE_CORE);
            output.accept(SPIDER_CORE);
            output.accept(CURSED_BOOK);
            output.accept(RUNESTONE);
            output.accept(POLISHED_RUNESTONE);
            output.accept(RUNESTONE_UPGRADE_SMITHING_TEMPLATE);
        });

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT).register(output-> {
            output.accept(RUNESTONE_SWORD);
            output.accept(RUNESTONE_SPEAR);
        });

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(output-> {
            output.accept(RUNESTONE_PICKAXE);
            output.accept(RUNESTONE_AXE);
            output.accept(RUNESTONE_SHOVEL);
            output.accept(RUNESTONE_HOE);
            output.accept(STORY_BOOK);
        });

    }
}
