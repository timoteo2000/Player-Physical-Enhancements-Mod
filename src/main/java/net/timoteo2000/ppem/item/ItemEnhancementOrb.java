package net.timoteo2000.ppem.item;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import net.timoteo2000.ppem.utils.NBTHelper;

public class ItemEnhancementOrb extends ItemPPEM {
	
	public ItemEnhancementOrb(){
		super();
		this.setUnlocalizedName("enhancementOrb");
		setHasSubtypes(true);
		setMaxStackSize(64);
		this.enhanceId = 0;
		this.enhanceLevel = 0;
	}
	/*The array of enhancement types by ID:
	 * 0=Attack Damage
	 * 1=Movement Speed*/
	public static final int[] enhancements = {0,1};
	/*The array enhancement levels*/
	public static final int[] levels = {0,1};
	public final int enhanceId;
	public final int enhanceLevel;
	NBTHelper helper = new NBTHelper();
	NBTTagList taglist = new NBTTagList();
	Random rand = new Random();
	
	public int getEnhanceId(){
		Item item = new Item();
		ItemStack stack = new ItemStack(item);
		if(helper.getInt(stack, "Enhancement ID")==0){
			return 0;
		}
		return 0; 
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player){
		return itemstack;
	}
	
	//Not actually important, all enhancement orbs will have the same name
	/*@Override
	public String getUnlocalizedName(ItemStack stack){
		return getUnlocalizedName() + "." + stack.getItemDamage();
	}*/
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean boo){
		
	}
	
	/*Adds a random enhancement and level to an orb, used when the orb is dropped from a mob.*/
	public void addRandomEnhancement(ItemStack stack){
		
		helper.setInt(stack, "Enhancement ID", rand.nextInt(1));
		helper.setInt(stack, "Enhancement Level", rand.nextInt(1));
	}
	
	public NBTTagList nbtlist(ItemStack stack){
		return stack.stackTagCompound != null && stack.stackTagCompound.hasKey("Enhancement ID", 9) ? (NBTTagList)stack.stackTagCompound.getTag("Enhancement ID") : new NBTTagList();
	}
}
