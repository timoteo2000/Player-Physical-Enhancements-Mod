package net.timoteo2000.ppem.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.InventoryBasic;

public class ContainerEnhancementTable extends Container{
	
	
	
	public ContainerEnhancementTable(EntityPlayer player){
		inventory = new InventoryBasic("", false, 0);
	}

	private final InventoryBasic inventory;
	
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return true;
	}

}
