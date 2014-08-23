package net.timoteo2000.ppem.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.timoteo2000.ppem.init.ModItems;
import net.timoteo2000.ppem.reference.Reference;

public class CreativeTabPPEM {
	public static final CreativeTabs PPEM_TAB = new CreativeTabs(Reference.MOD_ID.toLowerCase()){
		@Override
		public Item getTabIconItem(){
			return null;
		}
	};
}
