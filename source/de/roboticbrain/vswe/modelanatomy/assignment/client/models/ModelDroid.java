package de.roboticbrain.vswe.modelanatomy.assignment.client.models;

import java.util.ArrayList;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelDroid extends ModelBase {
	
	private ArrayList<ModelRenderer> parts;
	
	private ModelRenderer head;
	private ModelRenderer upArm;
	private ModelRenderer lowArm;
	
	public ModelDroid() {
		
		textureWidth = 64;
		textureHeight = 32;
		
		parts = new ArrayList<ModelRenderer>();
		
		
		// Body
		ModelRenderer body = new ModelRenderer(this, 0, 0);
		body.addBox(-4F, -6F, -4F,
					8, 12, 8);
		body.setRotationPoint(0, 0, 0);
		parts.add(body);
		
		
		// Head
		head = new ModelRenderer(this, 0, 20);
		head.addBox(-4.5F, -0.5F, -4.5F,
					9, 1, 9);
		head.setRotationPoint(0, -6.5F, 0);
		parts.add(head);
		
		// Arm Mount
		ModelRenderer mount = new ModelRenderer(this, 24, 0);
		mount.addBox(-0.9F, -1F, -1.5F,
						2, 2, 3);
		mount.setRotationPoint(4F, -3.5F, 0F);
		parts.add(mount);
		
		// Upper Arm
		upArm = new ModelRenderer(this, 0, 0);
		upArm.addBox(-0.5F, -0.5F, -1F,
						1, 6, 2);
		upArm.setRotationPoint(0.5F, 0, 0);
		//upArm.rotateAngleZ = -(float)Math.PI / 2;
		mount.addChild(upArm);
		
		// Lower Arm
		lowArm = new ModelRenderer(this, 0, 0);
		lowArm.addBox(-0.5F, -0.5F, -1F,
				1, 6, 2);
		lowArm.setRotationPoint(0, 5.5F, 0);
		//lowArm.rotateAngleZ = -(float)Math.PI / 2;
		upArm.addChild(lowArm);
		
		
	}
	
	@Override
	public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7) {
		System.err.println("Change Method call!");
	}
	
	public void render(float topRotation, float upArmRot, float lowArmRot, float scale) {
		
		head.rotateAngleY = topRotation;
		upArm.rotateAngleZ = upArmRot;
		lowArm.rotateAngleZ = lowArmRot;
		
		for (ModelRenderer part : parts) {
			part.render(scale);
		}
	}
}
