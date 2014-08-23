package net.timoteo2000.ppem.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.timoteo2000.ppem.creativetab.CreativeTabPPEM;
import net.timoteo2000.ppem.reference.Reference;

public abstract class BlockPPEM extends Block {
	public BlockPPEM(Material material){
		super(material);
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float clickX, float clickY, float clickZ){
		return false;
	}
	
	public BlockPPEM(){
		this(Material.rock);
		this.setCreativeTab(CreativeTabPPEM.PPEM_TAB);
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

	public abstract Integer getGui(World world, int x, int y, int z, EntityPlayer entityplayer);
	
}
