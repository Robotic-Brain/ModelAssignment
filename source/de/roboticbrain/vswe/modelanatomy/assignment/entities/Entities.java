package de.roboticbrain.vswe.modelanatomy.assignment.entities;

import cpw.mods.fml.common.registry.EntityRegistry;
import de.roboticbrain.vswe.modelanatomy.assignment.ModelAssignment;

public class Entities {

	public static void init() {
		EntityRegistry.registerModEntity(EntityDroid.class, "EntityDroid", 0, ModelAssignment.instance, 80, 3, true);
	}
	
}
