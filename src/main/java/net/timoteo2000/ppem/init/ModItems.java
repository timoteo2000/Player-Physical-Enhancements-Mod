package net.timoteo2000.ppem.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.timoteo2000.ppem.item.ItemEnhancementOrb;
import net.timoteo2000.ppem.item.ItemPPEM;
import net.timoteo2000.ppem.reference.Reference;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems {
	/* DO NOT MODIFY COMMENTED METHODS/STATMENTS. ONLY COPY AS A TEMPLATE. */
	
	//public static final ItemPPEM itemName = new ItemClass();
	public static final ItemEnhancementOrb enhancementOrb = new ItemEnhancementOrb();
	
	public static void init(){
		//GameRegistry.registerItem(itemName, "itemUnlocalizedName");
		GameRegistry.registerItem(enhancementOrb, "enhancementOrb");
	}
}
