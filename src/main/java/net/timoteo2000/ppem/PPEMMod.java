package net.timoteo2000.ppem;

import net.timoteo2000.ppem.handler.ConfigHandler;
import net.timoteo2000.ppem.init.ModBlocks;
import net.timoteo2000.ppem.init.ModItems;
import net.timoteo2000.ppem.init.Recipes;
import net.timoteo2000.ppem.proxy.IProxy;
import net.timoteo2000.ppem.reference.Reference;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid=Reference.MOD_ID,version=Reference.VERSION,guiFactory=Reference.GUI_FACTORY)
public class PPEMMod {
	
	@Mod.Instance
	public static PPEMMod instance;
	
	@SidedProxy(clientSide=Reference.CLIENT_PROXY,serverSide=Reference.SERVER_PROXY)
	public static IProxy proxy;
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event){
		 ConfigHandler.init(event.getSuggestedConfigurationFile());
		 FMLCommonHandler.instance().bus().register(new ConfigHandler());
		 
		 ModItems.init();
		 
		 ModBlocks.init();
		 
		 Recipes.init();
	}
	
	@Mod.EventHandler
	public void init(FMLInitializationEvent event){
		
	}
	
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event){
		
	}
}
