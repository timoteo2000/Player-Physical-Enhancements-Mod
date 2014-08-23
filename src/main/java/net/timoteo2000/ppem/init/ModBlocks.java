package net.timoteo2000.ppem.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.BlockContainer;
import net.timoteo2000.ppem.block.BlockEnhancementTable;
import net.timoteo2000.ppem.block.BlockPPEM;
import net.timoteo2000.ppem.reference.Reference;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModBlocks {
	/** DO NOT MODIFY COMMENTED METHODS/STATMENTS. ONLY COPY AS A TEMPLATE. **/
	
	//public static final BlockPPEM blockName = new BlockClass();
	public static final BlockContainer enhancementTable = new BlockEnhancementTable();
	
	public static void init(){
		//GameRegistry.registerBlock(blockName, "blockUnlocalizedName");
		GameRegistry.registerBlock(enhancementTable, "enhancementTable");
	}

}
