package net.timoteo2000.ppem.block;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.timoteo2000.ppem.PPEMMod;
import net.timoteo2000.ppem.proxy.CommonProxy;

public class BlockEnhancementTable extends BlockPPEM {
	public BlockEnhancementTable(){
		super();
	}
	
	@Override
    public Integer getGui(World world, int x, int y, int z, EntityPlayer entityplayer)
    {
        // return -1;
        return CommonProxy.enhancementTableGuiID;
    }
	
	/*public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player){ //This is supposed to open a Gui when the block is rightclicked but im still trying to figure out how this works.
		Integer integer = getGui(world, x, y, z, player);
		if (player.isSneaking())
            return false;
        else
        {
            player.openGui(getModInstance(), integer, world, x, y, z);
            return true;
        }
	}*/

	private Object getModInstance() {
		return PPEMMod.instance;
	}
}
