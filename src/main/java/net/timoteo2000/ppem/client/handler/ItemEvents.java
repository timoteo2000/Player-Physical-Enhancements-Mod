package net.timoteo2000.ppem.client.handler;

import java.util.Random;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.timoteo2000.ppem.init.ModBlocks;
import net.timoteo2000.ppem.init.ModItems;
import net.timoteo2000.ppem.item.ItemEnhancementOrb;
import net.timoteo2000.ppem.utils.LogHelper;

public class ItemEvents {
	
	private static ItemStack orb = new ItemStack(ModItems.enhancementOrb, 1);
	private Random rand = new Random();
	
	@SubscribeEvent
	public void onLivingDrops(LivingDropsEvent event){
		EntityLivingBase mob = event.entityLiving;
		if(event.source.getEntity() instanceof EntityPlayer && rand.nextInt(10) == 0){
			EntityPlayer player = (EntityPlayer) event.source.getEntity();
			event.drops.add(new EntityItem(mob.worldObj, mob.posX, mob.posY, mob.posZ, orb.copy()));
			LogHelper.info("SOMETHING DROPPED, RIGHT?!");
		}
	}

}
