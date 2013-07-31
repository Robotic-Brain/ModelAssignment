package de.roboticbrain.vswe.modelanatomy.assignment.items;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.item.Item;

public class Items {

	public static Item droid;
	
	public static void init() {
		droid = new ItemDroid(ItemInfo.DROID_ID);
		//GameRegistry.registerItem(droid, ItemInfo.DROID_KEY); // TODO What's that?
	}

	public static void addNames() {
		LanguageRegistry.addName(droid, ItemInfo.DROID_NAME);
	}
	
}
