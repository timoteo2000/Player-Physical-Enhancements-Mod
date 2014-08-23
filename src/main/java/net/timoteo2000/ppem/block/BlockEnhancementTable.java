package net.timoteo2000.ppem.block;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.timoteo2000.ppem.PPEMMod;
import net.timoteo2000.ppem.client.handler.GuiHandler;
import net.timoteo2000.ppem.proxy.CommonProxy;
import net.timoteo2000.ppem.reference.Reference;
import net.timoteo2000.ppem.utils.LogHelper;

public class BlockEnhancementTable extends BlockContainer {
	public BlockEnhancementTable(){
		super(Material.rock);
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

	@Override
	public TileEntity createNewTileEntity(World world, int integer) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
    public String getUnlocalizedName()
    {
        return String.format("tile.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconReg)
    {
        blockIcon = iconReg.registerIcon(String.format("%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName())));
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
}
