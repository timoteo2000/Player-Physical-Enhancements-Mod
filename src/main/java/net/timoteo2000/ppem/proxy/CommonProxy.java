package net.timoteo2000.ppem.proxy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.timoteo2000.ppem.client.gui.GuiEnhancementTable;
import cpw.mods.fml.common.network.IGuiHandler;

public abstract class CommonProxy implements IProxy,IGuiHandler {
	
	@Override
	public void registerKeyBindings() {}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		if(ID == GuiEnhancementTable.GUI_ID)
			return new GuiEnhancementTable();
		return null;
	}

}
