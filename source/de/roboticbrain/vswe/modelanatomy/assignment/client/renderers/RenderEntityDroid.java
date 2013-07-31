package de.roboticbrain.vswe.modelanatomy.assignment.client.renderers;

import org.lwjgl.opengl.GL11;

import de.roboticbrain.vswe.modelanatomy.assignment.ModInfo;
import de.roboticbrain.vswe.modelanatomy.assignment.client.models.ModelDroid;
import de.roboticbrain.vswe.modelanatomy.assignment.entities.EntityDroid;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderEntityDroid extends Render {
	
	private ModelDroid model;
	
	private static final ResourceLocation texture = new ResourceLocation(ModInfo.MAIN_ASSET_LOCATION, "textures/models/droid.png");
	
	public RenderEntityDroid(ModelDroid model) {
		this.model = model;
		shadowSize = 0.5F;
	}

	@Override
	public void doRender(Entity entity, double x, double y, double z, float yaw, float partialTickTime) {
		
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x, (float)y, (float)z);
		GL11.glScalef(-1F, -1F, 1F);
		
		func_110777_b(entity);
		
		EntityDroid droid = (EntityDroid)entity;
		
		model.render(droid.getHeadRotation(), droid.getUpperArmRotation(), droid.getLowerArmRotation(), 0.0625F);
		
		GL11.glPopMatrix();
	}
	
	@Override
	protected ResourceLocation func_110775_a(Entity entity) {
		return texture;
	}
	
}
