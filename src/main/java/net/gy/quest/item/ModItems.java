package net.gy.quest.item;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.gy.quest.Deliverance;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

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

    private static Item registerItem(String name, Function<Item.Properties, Item> function) {
        return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(Deliverance.MOD_ID, name),
                function.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Deliverance.MOD_ID, name)))));
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
                }
                );
    }
}
