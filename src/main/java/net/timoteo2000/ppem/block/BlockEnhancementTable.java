package net.timoteo2000.ppem.block;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.timoteo2000.ppem.PPEMMod;
import net.timoteo2000.ppem.client.handler.GuiHandler;
import net.timoteo2000.ppem.proxy.CommonProxy;
import net.timoteo2000.ppem.utils.LogHelper;

public class BlockEnhancementTable extends BlockPPEM {
	public BlockEnhancementTable(){
		super();
	}
	
	@Override
    public Integer getGui(World world, int x, int y, int z, EntityPlayer entityplayer)
    {
        // return -1;
        return GuiHandler.enhancementTableGuiID;
    }
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float clickX, float clickY, float clickZ){ //This is supposed to open a Gui when the block is rightclicked but im still trying to figure out how this works.
		LogHelper.info("111111111111111111111111111111");
		FMLNetworkHandler handler = new FMLNetworkHandler();
		if(world.isRemote){
		    handler.openGui(player, getModInstance(), 0, world, x, y, z);
		}
		return true;
		}

	private Object getModInstance() {
		return PPEMMod.instance;
	}
}
