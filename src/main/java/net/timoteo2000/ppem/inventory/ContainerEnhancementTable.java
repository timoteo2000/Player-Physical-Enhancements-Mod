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
import net.minecraft.item.Item;
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
	private IInventory inputSlots = new InventoryBasic("Enhance", true, 2);
	
	
	public ContainerEnhancementTable(InventoryPlayer inv, World world, int index, int x, int y){
		//Top slot
		/*Apparently, the 2nd parameter is not an x coordinate, it is an inventory index, telling us which slot is which. I assigned both to 0, causing interesting problems.*/
		this.addSlotToContainer(new SlotTable(tableInventory, 0, 20, 19));
		this.addSlotToContainer(new SlotTable(tableInventory, 1, 20, 50));
		
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
	
	public IInventory tableInventory = new InventoryBasic("Enhance", true, 2){
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

            if (p_82846_2_ == 2)
            {
                if (!this.mergeItemStack(itemstack1, 3, 39, true))
                {
                    return null;
                }

                slot.onSlotChange(itemstack1, itemstack);
            }
            else if (p_82846_2_ != 0 && p_82846_2_ != 1)
            {
                if (p_82846_2_ >= 3 && p_82846_2_ < 39 && !this.mergeItemStack(itemstack1, 0, 2, false))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 3, 39, false))
            {
                return null;
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

class SlotTable extends Slot{

	public SlotTable(IInventory inv, int index, int x,
			int y) {
		super(inv, index, x, y);
	}
	
	@Override
	public boolean isItemValid(ItemStack item){
		return item != null && item.getItem() instanceof ItemEnhancementOrb || item.getItem() instanceof ItemArmor; 
	}
	}
}