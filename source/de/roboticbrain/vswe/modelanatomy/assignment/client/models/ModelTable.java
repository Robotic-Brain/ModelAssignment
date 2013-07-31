package de.roboticbrain.vswe.modelanatomy.assignment.client.models;

import java.util.ArrayList;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelTable extends ModelBase {
	
	private ArrayList<ModelRenderer> parts;
	
	public ModelTable() {
		parts = new ArrayList<ModelRenderer>();
		
		ModelRenderer top = new ModelRenderer(this);
		top.addBox(0, 0, 0, 16, 16, 16);
		parts.add(top);
	}
	
	public void render(float scale) {
		for (ModelRenderer part : parts) {
			part.render(scale);
		}
	}
}
