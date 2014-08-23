package net.timoteo2000.ppem.client.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.timoteo2000.ppem.block.BlockEnhancementTable;
import net.timoteo2000.ppem.client.gui.GuiEnhancementTable;
import net.timoteo2000.ppem.inventory.ContainerEnhancementTable;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {
	
	public static final int enhancementTableGuiID = GuiEnhancementTable.GUI_ID;
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		if(ID==0){
			//return new ContainerEnhancementTable(player);
			return new GuiEnhancementTable();
		}
			return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		if(ID==0){
			//return new ContainerEnhancementTable(player);
			return new GuiEnhancementTable();
		}
		return null;
	}
	
	/*private static HashMap<Integer, IGuiHandler> serverGuiHandlers = new HashMap<Integer, IGuiHandler>();
    private static HashMap<Integer, IGuiHandler> clientGuiHandlers = new HashMap<Integer, IGuiHandler>();
    
    public static void registerServerGuiHandler(int gui, IGuiHandler handler)
    {
        serverGuiHandlers.put(gui, handler);
    }
    
    public static void registerClientGuiHandler(int gui, IGuiHandler handler)
    {
        clientGuiHandlers.put(gui, handler);
    }*/


}
