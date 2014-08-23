package net.timoteo2000.ppem.handler;

import java.io.File;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;
import net.timoteo2000.ppem.reference.Reference;

public class ConfigHandler {
	
	/** DO NOT MODIFY COMMENTED METHODS/STATMENTS. ONLY COPY AS A TEMPLATE. **/
	
	public static Configuration config;
	//public static boolean/int/whatev configValue = null;
	
	public static void init(File configFile){
		if(config == null){
			config = new Configuration(configFile);
			loadConfig();
		}
	}
	
	
	private static void loadConfig(){
		//configValue = config.getBoolean/Int/Whatev("configValue", Configuration.CATEGORY_GENERAL, null, "ToolTip");
		if(config.hasChanged()){
			config.save();
		}
	}
	
	@SubscribeEvent
	public void onConfigChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event){
		if(event.modID.equals(Reference.MOD_ID)){
			//Resync configs
			loadConfig();
		}
	}
}
