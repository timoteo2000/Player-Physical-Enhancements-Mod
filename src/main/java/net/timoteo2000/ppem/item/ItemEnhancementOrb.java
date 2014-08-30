package net.timoteo2000.ppem.item;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import net.timoteo2000.ppem.client.handler.IPickupHandler;
import net.timoteo2000.ppem.init.ModItems;
import net.timoteo2000.ppem.reference.Reference;
import net.timoteo2000.ppem.utils.LogHelper;
import net.timoteo2000.ppem.utils.NBTHelper;

public class ItemEnhancementOrb extends ItemPPEM implements IPickupHandler{
	
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
	 * 1=Movement Speed
	 * 2=Max Health
	 * 3=Knockback Resistance*/
	public static final int[] enhancements = {0,1,2,3};
	/*The array of enhancement levels*/
	public static final int[] levels = {0,1,2,3};
	public final int enhanceId;
	public final int enhanceLevel;
	NBTHelper helper = new NBTHelper();
	NBTTagList taglist = new NBTTagList();
	Random rand = new Random();
	Item item = new Item();
	ItemStack stack = new ItemStack(item);
	
	public int getEnhanceId(){
		if(helper.getInt(stack, "Enhancement ID")==0)
			return 0;
		if(helper.getInt(stack, "Enhancement ID")==1)
			return 1;
		if(helper.getInt(stack, "Enhancement ID")==2)
			return 2;
		if(helper.getInt(stack, "Enhancement ID")==3)
			return 3;
		return 0; 
	}
	
	public String getEnhancementUnlocalizedNameById(){
		return String.format("enhance.%s%s", Reference.MOD_ID.toLowerCase() + ":", helper.getInt(stack, "Enhancement ID"));
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
		super.addInformation(stack, player, list, boo);
		NBTTagList nbtlist = this.nbtlist(stack);
		if(nbtlist != null){
			String id = this.getEnhancementUnlocalizedNameById();
			int level = helper.getInt(stack, "Enhancement Level");
			
			list.add(id + " " + level);
		}
	}
	@Override
	public EnumRarity getRarity(ItemStack stack){
		if(helper.getInt(stack, "Enhancement Level") == 0){
			return EnumRarity.uncommon;
		}else if(helper.getInt(stack, "Enhancement Level")==1){
			return EnumRarity.rare;
		}
		return EnumRarity.common;
	}
	
	/*Adds a random enhancement and level to an orb, used when the orb is dropped from a mob.*/
	/*Still random, but different the different levels are rarer and there are more levels now.*/
	/*^^ Adding the above later ^^*/
	public void addRandomEnhancement(ItemStack stack){
		
		helper.setInt(stack, "Enhancement ID", rand.nextInt(4));
		helper.setInt(stack, "Enhancement Level", rand.nextInt(2));
		/*if(rand.nextInt(2)==1){
			helper.setInt(stack, "Enhancement Level", 0);
			LogHelper.info("6666666666666665655");
		}else if(rand.nextInt(1)==1){
			helper.setInt(stack, "Enhancement Level", 1);
			LogHelper.info("777777777777777676");
		}*/
		helper.setBoolean(stack, "Written", true);
	}
	
	public NBTTagList nbtlist(ItemStack stack){
		return stack.stackTagCompound != null && stack.stackTagCompound.hasKey("Enhancement ID", 9) ? (NBTTagList)stack.stackTagCompound.getTag("Enhancement ID") : new NBTTagList();
	}

	@Override
	public boolean onItemPickup(ItemStack stack, EntityPlayer player) {
		if(helper.getBoolean(stack, "Written")!=true){
			this.addRandomEnhancement(stack);
		}
		return true;
	}
	
	
}
