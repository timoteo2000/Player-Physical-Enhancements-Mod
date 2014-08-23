package net.timoteo2000.ppem.client.gui;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerChest;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.timoteo2000.ppem.block.tileentity.TileEntityEnhancementTable;
import net.timoteo2000.ppem.inventory.ContainerEnhancementTable;
import net.timoteo2000.ppem.reference.Reference;

public class GuiEnhancementTable extends GuiContainer {
	public static final int GUI_ID = 0;
	private static ContainerEnhancementTable containerEnhancementTable;
	private static final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID.toLowerCase() + ":textures/gui/enhancing_table.png");
	private static TileEntityEnhancementTable tileEntityEnhancementTable;
	
	public GuiEnhancementTable(InventoryPlayer inv, World world, int x, int y, int z){
		super(new ContainerEnhancementTable(inv, world, x, y, z));
		this.containerEnhancementTable = (ContainerEnhancementTable)this.inventorySlots;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
		// TODO Work on this. I have no clue what anything here does, but I guess the possibilities are endless?
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		mc.getTextureManager().bindTexture(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		
	}
	@Override
	protected void drawGuiContainerForegroundLayer(int par1, int par2) {
		// TODO Work on this. I have no clue what anything here does, but I guess the possibilities are endless?
		this.fontRendererObj.drawString("Enhance", 12, 5, 4210752);
		this.fontRendererObj.drawString(I18n.format("container.inventory"), 8, ySize - 96 + 2, 4210752);
	}
}
