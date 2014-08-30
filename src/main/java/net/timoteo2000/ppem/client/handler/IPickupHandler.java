package net.timoteo2000.ppem.client.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public interface IPickupHandler {
	
	public boolean onItemPickup(ItemStack stack, EntityPlayer player);

}
