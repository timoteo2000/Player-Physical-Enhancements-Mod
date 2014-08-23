package net.timoteo2000.ppem.proxy;

import net.timoteo2000.ppem.PPEMMod;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;

public interface IProxy {
	public abstract void registerKeyBindings();
}
