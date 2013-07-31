package de.roboticbrain.vswe.modelanatomy.assignment.proxies;

import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.RenderingRegistry;
import de.roboticbrain.vswe.modelanatomy.assignment.blocks.BlockInfo;
import de.roboticbrain.vswe.modelanatomy.assignment.client.models.ModelDroid;
import de.roboticbrain.vswe.modelanatomy.assignment.client.renderers.RenderEntityDroid;
import de.roboticbrain.vswe.modelanatomy.assignment.client.renderers.RenderItemDroid;
import de.roboticbrain.vswe.modelanatomy.assignment.client.renderers.RenderTable;
import de.roboticbrain.vswe.modelanatomy.assignment.entities.EntityDroid;
import de.roboticbrain.vswe.modelanatomy.assignment.items.ItemInfo;

public class ClientProxy extends CommonProxy {
	
	public void initSounds() {
	}

	public void initRenderers() {
		RenderTable tableRenderer = new RenderTable();
		BlockInfo.TABLE_RENDER_ID = tableRenderer.getRenderId();
		RenderingRegistry.registerBlockHandler(tableRenderer);
		//MinecraftForgeClient.registerItemRenderer(BlockInfo.TABLE_ID, new RenderTableItem());		// TODO DEAD CODE
		
		ModelDroid model = new ModelDroid();
		MinecraftForgeClient.registerItemRenderer(ItemInfo.DROID_ID + 256, new RenderItemDroid(model));
		RenderingRegistry.registerEntityRenderingHandler(EntityDroid.class, new RenderEntityDroid(model));
	}
	
}
