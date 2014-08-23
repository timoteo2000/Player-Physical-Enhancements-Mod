package net.timoteo2000.ppem.proxy;

import cpw.mods.fml.client.registry.ClientRegistry;
import net.timoteo2000.ppem.client.settings.KeyBindings;

public class ClientProxy extends CommonProxy {

	@Override
	public void registerKeyBindings() {
		ClientRegistry.registerKeyBinding(KeyBindings.open); //This registers key bindings.
	}

}
