package de.roboticbrain.vswe.modelanatomy.assignment;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import de.roboticbrain.vswe.modelanatomy.assignment.blocks.Blocks;
import de.roboticbrain.vswe.modelanatomy.assignment.config.ConfigHandler;
import de.roboticbrain.vswe.modelanatomy.assignment.entities.Entities;
import de.roboticbrain.vswe.modelanatomy.assignment.items.Items;
import de.roboticbrain.vswe.modelanatomy.assignment.network.PacketHandler;
import de.roboticbrain.vswe.modelanatomy.assignment.proxies.CommonProxy;

@Mod(	modid = ModInfo.ID,
		name = ModInfo.NAME,
		version = ModInfo.VERSION)
@NetworkMod(	serverSideRequired = false,
				clientSideRequired = true,
				channels = {ModInfo.CHANNEL},
				packetHandler = PacketHandler.class)
public class ModelAssignment {
	
	@Instance(ModInfo.ID)
	public static ModelAssignment instance;
	
	@SidedProxy(	clientSide = "de.roboticbrain.vswe.modelanatomy.assignment.proxies.ClientProxy",
					serverSide = "de.roboticbrain.vswe.modelanatomy.assignment.proxies.CommonProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		ConfigHandler.init(event.getSuggestedConfigurationFile());
		Items.init();
		Blocks.init();
		
		proxy.initSounds();
		proxy.initRenderers();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		Blocks.addNames();
		Items.addNames();
		
		Blocks.registerTileEntities();
		
		Entities.init();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		
	}
}
