package net.gy.quest.menu;

import net.gy.quest.Deliverance;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Inventory;

public class StaffansCrafterScreen extends AbstractContainerScreen<StaffansCrafterMenu> {

    public static final Identifier TEXTURE =
            Identifier.fromNamespaceAndPath(Deliverance.MOD_ID, "textures/gui/staffans_crafter.png");

    public StaffansCrafterScreen(StaffansCrafterMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title, 176, 166);
    }

    @Override
    public void extractContents(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTick) {
        int x = this.leftPos;
        int y = this.topPos;
        guiGraphics.blit(RenderPipelines.GUI_TEXTURED, TEXTURE, x, y, 0, 0, 176, 166, 256, 256);
        super.extractContents(guiGraphics, mouseX, mouseY, partialTick);
    }
}
