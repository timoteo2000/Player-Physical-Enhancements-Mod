package net.timoteo2000.ppem.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.timoteo2000.ppem.creativetab.CreativeTabPPEM;
import net.timoteo2000.ppem.reference.Reference;

public class ItemPPEM extends Item {
	public ItemPPEM(){
		super();
		this.setCreativeTab(CreativeTabPPEM.PPEM_TAB);
	}
	
	@Override
	public String getUnlocalizedName(){
		return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemstack){
		return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	}
	
	protected String getUnwrappedUnlocalizedName(String unlocalizedName){
		return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconReg){
		itemIcon = iconReg.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".")+1));
	}
	
}
