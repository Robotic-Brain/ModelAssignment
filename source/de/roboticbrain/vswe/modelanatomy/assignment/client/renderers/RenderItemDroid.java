package de.roboticbrain.vswe.modelanatomy.assignment.client.renderers;

import org.lwjgl.opengl.GL11;

import de.roboticbrain.vswe.modelanatomy.assignment.ModInfo;
import de.roboticbrain.vswe.modelanatomy.assignment.client.models.ModelDroid;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

public class RenderItemDroid implements IItemRenderer {
	
	private ModelDroid model;
	
	private static final ResourceLocation texture = new ResourceLocation(ModInfo.MAIN_ASSET_LOCATION, "textures/models/droid.png");
	
	public RenderItemDroid(ModelDroid model) {
		this.model = model;
	}

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return true;
	}
	
	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		return true;
	}
	
	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		
		GL11.glPushMatrix();
		GL11.glScalef(-1F, -1F, 1F);
		
		switch (type) {
			case EQUIPPED_FIRST_PERSON:
				GL11.glTranslatef(0, -0.8F, 0.6F);
				break;
				
			case EQUIPPED:
				GL11.glTranslatef(-0.5F, -0.8F, 0.6F);
				
			default:
				break;
		}
		
		Minecraft.getMinecraft().func_110434_K().func_110577_a(texture);
		
		model.render(0, 0, 0, 0.0625F);
		
		GL11.glPopMatrix();
	}
	
}
