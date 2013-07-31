package de.roboticbrain.vswe.modelanatomy.assignment.items;

import de.roboticbrain.vswe.modelanatomy.assignment.entities.EntityDroid;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemDroid extends Item {

	public ItemDroid(int id) {
		super(id);
		setMaxStackSize(64);
		setCreativeTab(CreativeTabs.tabMisc);
		setUnlocalizedName(ItemInfo.DROID_UNLOCALIZED_NAME);
	}
	
	@Override
	public void registerIcons(IconRegister register) {
		
	}
	
	@Override
	public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		if (!world.isRemote) {
			EntityDroid entity = new EntityDroid(world);
			
			entity.posX = x + 0.5F;
			entity.posY = y + 1.5F;
			entity.posZ = z + 0.5F;
			
			world.spawnEntityInWorld(entity);
			
			stack.stackSize--;
			return true;
		} else {
			return false;
		}
	}
	
}
