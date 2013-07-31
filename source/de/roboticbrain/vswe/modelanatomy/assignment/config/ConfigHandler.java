package de.roboticbrain.vswe.modelanatomy.assignment.config;

import java.io.File;

import de.roboticbrain.vswe.modelanatomy.assignment.blocks.BlockInfo;
import de.roboticbrain.vswe.modelanatomy.assignment.items.ItemInfo;
import net.minecraftforge.common.Configuration;

public class ConfigHandler {

	public static void init(File file) {
		Configuration config = new Configuration(file);
		
		config.load();
		
		BlockInfo.TABLE_ID = config.getBlock(BlockInfo.TABLE_KEY, BlockInfo.TABLE_DEFAULT).getInt();
		
		ItemInfo.DROID_ID = config.getItem(ItemInfo.DROID_KEY, ItemInfo.DROID_DEFAULT).getInt() - 256;
		
		if (config.hasChanged()) {
			config.save();
		}
	}
	
}
