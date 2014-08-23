package net.timoteo2000.ppem.client.gui;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerChest;
import net.minecraft.tileentity.TileEntityChest;
import net.timoteo2000.ppem.inventory.ContainerEnhancementTable;

public class GuiEnhancementTable extends GuiScreen {
	public static final int GUI_ID = 0;
	private static ContainerEnhancementTable containerEnhancementTable;
	
	public GuiEnhancementTable(){
		//super(containerEnhancementTable);
	}
	
	@Override
	public void drawScreen(int par1, int par2, float par3){
		this.drawDefaultBackground();
	}

	/*@Override
	protected void drawGuiContainerBackgroundLayer(float p_146976_1_,
			int p_146976_2_, int p_146976_3_) {
		// TODO Auto-generated method stub
		
	}*/
}
