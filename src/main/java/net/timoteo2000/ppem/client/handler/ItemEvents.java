package net.timoteo2000.ppem.client.handler;

import java.util.Random;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.timoteo2000.ppem.init.ModBlocks;
import net.timoteo2000.ppem.init.ModItems;
import net.timoteo2000.ppem.item.ItemEnhancementOrb;
import net.timoteo2000.ppem.utils.LogHelper;

public class ItemEvents {
	
	private static Item item = new Item();
	private static ItemStack stack = new ItemStack(item);
	private static ItemStack orb = new ItemStack(ModItems.enhancementOrb, 1);
	private static ItemEnhancementOrb enhancementOrb = new ItemEnhancementOrb();
	private static World world;
	private static EntityItem itemEntity;
	private Random rand = new Random();
	
	@SubscribeEvent
	public void onLivingDrops(LivingDropsEvent event){
		EntityLivingBase mob = event.entityLiving;
		if(event.source.getEntity() instanceof EntityPlayer && rand.nextInt(1) == 0){
			EntityPlayer player = (EntityPlayer) event.source.getEntity();
			event.drops.add(new EntityItem(mob.worldObj, mob.posX, mob.posY, mob.posZ, orb.copy()));
		}
	}
	/*@SubscribeEvent
	public void onPlayerPickup(EntityItemPickupEvent event){
		EntityPlayer player = event.entityPlayer;
		if(event.item.isEntityEqual(orbEntity) == true){
			enhancementOrb.addRandomEnhancement(orb);
		}
	}*/
	
	@SubscribeEvent
	public void onItemPickup(EntityItemPickupEvent event) {
		ItemStack stack = event.item.getEntityItem();
		EntityPlayer player = event.entityPlayer;
		if(stack != null && stack.getItem() instanceof ItemEnhancementOrb){
			LogHelper.info("4444444444444444444444444");
			enhancementOrb.onItemPickup(stack, player);
		}
	}

}
