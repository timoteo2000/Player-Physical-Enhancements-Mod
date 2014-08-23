package net.timoteo2000.ppem.client.gui;

import java.util.List;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.timoteo2000.ppem.handler.ConfigHandler;
import net.timoteo2000.ppem.reference.Reference;
import cpw.mods.fml.client.config.GuiConfig;
import cpw.mods.fml.client.config.IConfigElement;

public class ModGuiConfig extends GuiConfig {

	public ModGuiConfig(GuiScreen guiScreen) {
		super(guiScreen,
				new ConfigElement(ConfigHandler.config.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(),
				Reference.MOD_ID,
				false,
				false,
				GuiConfig.getAbridgedConfigPath(ConfigHandler.config.toString()));
	}

}
