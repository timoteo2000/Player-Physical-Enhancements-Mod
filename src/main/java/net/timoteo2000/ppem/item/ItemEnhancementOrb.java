package net.timoteo2000.ppem.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.timoteo2000.ppem.utils.NBTHelper;

public class ItemEnhancementOrb extends ItemPPEM {
	
	public ItemEnhancementOrb(){
		super();
		this.setUnlocalizedName("enhancementOrb");
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player){
		NBTHelper.setString(itemstack, "String", "This is an NBT String, written to this item!");
		return itemstack;
	}
}
