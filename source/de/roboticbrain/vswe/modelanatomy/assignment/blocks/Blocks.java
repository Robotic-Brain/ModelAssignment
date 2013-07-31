package de.roboticbrain.vswe.modelanatomy.assignment.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;

public class Blocks {
	
	public static Block table;
	
	public static void init() {
		table = new BlockTable(BlockInfo.TABLE_ID);
		GameRegistry.registerBlock(table, BlockInfo.TABLE_KEY);
	}

	public static void addNames() {
		LanguageRegistry.addName(table, BlockInfo.TABLE_NAME);
	}

	public static void registerTileEntities() {
	}
	
}
