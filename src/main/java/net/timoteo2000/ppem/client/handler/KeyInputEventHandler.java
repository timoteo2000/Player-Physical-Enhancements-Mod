package net.timoteo2000.ppem.client.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.timoteo2000.ppem.PPEMMod;
import net.timoteo2000.ppem.client.gui.GuiEnhancementTable;
import net.timoteo2000.ppem.client.settings.KeyBindings;
import net.timoteo2000.ppem.proxy.CommonProxy;
import net.timoteo2000.ppem.reference.EKey;
import net.timoteo2000.ppem.reference.Reference;
import net.timoteo2000.ppem.utils.LogHelper;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;

public class KeyInputEventHandler {
	
	private static CommonProxy commonProxy;
	private static EntityPlayer player;
	private static World world;
	
	private static EKey getPressedKeyBinding(){
		if(KeyBindings.open.isPressed()){ //Essentially, this checks to see if a key binding is being pressed, then returns the enumeration value if it is, allowing handleKeyInputEvent to hear/handle it.
			return EKey.OPEN;
		}
		return EKey.UNKNOWN; // < Returns unknown if no recognized key bindings are pressed.
	}
	
	@SubscribeEvent
	public void handleKeyInputEvent(InputEvent.KeyInputEvent event){
		//This is where you set what things do when you press keys. Pretty much useless for me at the moment.
		//LogHelper.info(getPressedKeyBinding());
		if((KeyBindings.open.isPressed())&&world.isRemote){
		}
	}
}