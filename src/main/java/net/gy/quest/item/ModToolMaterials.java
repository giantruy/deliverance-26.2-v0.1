package net.gy.quest.item;

import net.gy.quest.Deliverance;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;

import java.lang.classfile.ClassFile;

public class ModToolMaterials {
    public static final TagKey<Item> REPAIRS_RUNESTONE_TOOLS = TagKey.create(
            BuiltInRegistries.ITEM.key(),
            Identifier.fromNamespaceAndPath(Deliverance.MOD_ID, "repairs_runestone_tools")
    );

    public static final ToolMaterial RUNESTONE_TOOL_MATERIAL = new ToolMaterial(
            BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
            1900,
            8.5f,
            3.5f,
            12,
            REPAIRS_RUNESTONE_TOOLS
    );
}
