package net.gy.quest.menu;

import com.mojang.datafixers.util.Function3;
import net.gy.quest.Deliverance;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;

public class ModMenuTypes {

    public static final MenuType<StaffansCrafterMenu> STAFFANS_CRAFTER_MENU =
            Registry.register(BuiltInRegistries.MENU,
                    Identifier.fromNamespaceAndPath(Deliverance.MOD_ID, "staffans_crafter_menu"),
                    new MenuType<>(StaffansCrafterMenu::new, FeatureFlags.VANILLA_SET));



    public static void registerModMenus() {
        Deliverance.LOGGER.info("Registering Mod Menus for " + Deliverance.MOD_ID);
    }
}
