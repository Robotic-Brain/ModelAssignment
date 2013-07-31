package de.roboticbrain.vswe.modelanatomy.assignment.blocks;

import com.google.common.collect.SetMultimap;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockTable extends Block {

	public BlockTable(int id) {
		super(id, Material.wood);
		setHardness(1F);
		setStepSound(soundWoodFootstep);
		setUnlocalizedName(BlockInfo.TABLE_UNLOCALIZED_NAME);
		setCreativeTab(CreativeTabs.tabBlock);
	}
	
	@Override
	public void registerIcons(IconRegister register) {
		blockIcon = Block.planks.getIcon(1, 0);
	}
	
	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	
	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}
	
	@Override
	public int getRenderType() {
		return BlockInfo.TABLE_RENDER_ID;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int x, int y, int z) {
		setBlockBoundsBasedOnState(world, x, y, z);
		return super.getSelectedBoundingBoxFromPool(world, x, y, z);
	}
	
	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
		setBlockBoundsBasedOnState(world, x, y, z);
		return super.getCollisionBoundingBoxFromPool(world, x, y, z);
	}
	
	@Override
	public MovingObjectPosition collisionRayTrace(World world, int x, int y, int z, Vec3 start, Vec3 end) {
		setBlockBoundsBasedOnState(world, x, y, z);
		return super.collisionRayTrace(world, x, y, z, start, end);
	}
	
	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess par1iBlockAccess, int par2, int par3, int par4) {
		setBlockBounds(0, 0, 0, 1, 1, 1);
	}
	
	@Override
	public void setBlockBoundsForItemRender() {
		setBlockBounds(0, 0, 0, 1, 1, 1);
	}
	
}
