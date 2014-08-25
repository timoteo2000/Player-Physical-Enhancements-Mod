package net.timoteo2000.ppem.inventory;

import java.util.Stack;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.timoteo2000.ppem.block.tileentity.TileEntityEnhancementTable;
import net.timoteo2000.ppem.item.ItemEnhancementOrb;

public class ContainerEnhancementTable extends Container{


	private InventoryBasic inventory;
	private World world;
	private TileEntityEnhancementTable table;
	
	
	public ContainerEnhancementTable(InventoryPlayer inv, World world, int x, int y, int z){
		//Top slot
		/*TODO it seems whenever an item is put in either slot, both slots display it can be picked out of either side, no duplication appears.*/
		this.addSlotToContainer(new SlotTable1(this.tableInventory, 0, 20, 19));
		//Bottom slot
		this.addSlotToContainer(new SlotTable2(this.tableInventory, 0, 20, 50));
		
		/*Inventory slots.*/
		for(int i = 0; i < 3; i++) {
			  for(int j = 0; j < 9; j++) {
			    this.addSlotToContainer(new Slot(inv, 9 + j + i * 9, 8 + j * 18, 84 + i * 18));
			  }
			}

		for (int i = 0; i < 9; ++i) {
			this.addSlotToContainer(new Slot(inv, i, 8 + i * 18, 142));
		}
	}
	
	public IInventory tableInventory = new InventoryBasic("Enhance", true, 1){
		public int getInventoryStackLimit(){
			return 1;
			
		}
	};
	
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return true;
	}
	
	@Override
	public void onContainerClosed(EntityPlayer player)
    {
        super.onContainerClosed(player);
        ItemStack itemstack = this.tableInventory.getStackInSlotOnClosing(0);
            if (itemstack != null)
            	player.dropPlayerItemWithRandomChoice(itemstack, false);
    }
	
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer p_82846_1_, int p_82846_2_)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(p_82846_2_);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (p_82846_2_ == 0)
            {
                if (!this.mergeItemStack(itemstack1, 1, 37, true))
                {
                    return null;
                }
            }
            else
            {
                if (((Slot)this.inventorySlots.get(0)).getHasStack() || !((Slot)this.inventorySlots.get(0)).isItemValid(itemstack1))
                {
                    return null;
                }

                if (itemstack1.hasTagCompound() && itemstack1.stackSize == 1)
                {
                    ((Slot)this.inventorySlots.get(0)).putStack(itemstack1.copy());
                    itemstack1.stackSize = 0;
                }
                else if (itemstack1.stackSize >= 1)
                {
                    ((Slot)this.inventorySlots.get(0)).putStack(new ItemStack(itemstack1.getItem(), 1, itemstack1.getItemDamage()));
                    --itemstack1.stackSize;
                }
            }

            if (itemstack1.stackSize == 0)
            {
                slot.putStack((ItemStack)null);
            }
            else
            {
                slot.onSlotChanged();
            }

            if (itemstack1.stackSize == itemstack.stackSize)
            {
                return null;
            }

            slot.onPickupFromSlot(p_82846_1_, itemstack1);
        }

        return itemstack;
    }
}

class SlotTable1 extends Slot{

	public SlotTable1(IInventory inv, int index, int x,
			int y) {
		super(inv, index, x, y);
	}
	
	@Override
	public boolean isItemValid(ItemStack item){
		return item != null && item.getItem() instanceof ItemEnhancementOrb; 
	}
	
	
}

class SlotTable2 extends Slot{

	public SlotTable2(IInventory inv, int index, int x,
			int y) {
		super(inv, index, x, y);
	}
	
	@Override
	public boolean isItemValid(ItemStack item){
		return item != null && item.getItem() instanceof ItemArmor; 
	}
	
	
}
