package net.timoteo2000.ppem;

import net.timoteo2000.ppem.client.gui.GuiEnhancementTable;
import net.timoteo2000.ppem.client.handler.GuiHandler;
import net.timoteo2000.ppem.client.handler.KeyInputEventHandler;
import net.timoteo2000.ppem.handler.ConfigHandler;
import net.timoteo2000.ppem.init.ModBlocks;
import net.timoteo2000.ppem.init.ModItems;
import net.timoteo2000.ppem.init.Recipes;
import net.timoteo2000.ppem.proxy.CommonProxy;
import net.timoteo2000.ppem.proxy.IProxy;
import net.timoteo2000.ppem.reference.Reference;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;

@Mod(modid=Reference.MOD_ID,version=Reference.VERSION,guiFactory=Reference.GUI_FACTORY)
public class PPEMMod {
	
	@Mod.Instance
	public static PPEMMod instance;
	@Instance("gui")
	public static GuiEnhancementTable guiInstance;
	
	@SidedProxy(clientSide=Reference.CLIENT_PROXY,serverSide=Reference.SERVER_PROXY)
	public static IProxy proxy;
	
	public static CommonProxy commonProxy;
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event){
		 ConfigHandler.init(event.getSuggestedConfigurationFile());
		 FMLCommonHandler.instance().bus().register(new ConfigHandler());
		 
		 ModItems.init();
		 
		 ModBlocks.init();
		 
		 Recipes.init();
		 
		 proxy.registerKeyBindings();
	}
	
	@Mod.EventHandler
	public void init(FMLInitializationEvent event){
		FMLCommonHandler.instance().bus().register(new KeyInputEventHandler());
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
	}
	
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event){
		
	}
}
