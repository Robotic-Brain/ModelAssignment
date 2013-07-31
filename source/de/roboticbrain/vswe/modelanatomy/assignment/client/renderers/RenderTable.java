package de.roboticbrain.vswe.modelanatomy.assignment.client.renderers;

import java.util.ArrayList;

import org.lwjgl.opengl.GL11;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.ForgeDirection;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class RenderTable implements ISimpleBlockRenderingHandler {
	
	private int id;
	
	public RenderTable() {
		id = RenderingRegistry.getNextAvailableRenderId();
	}
	
	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) {
		GL11.glPushMatrix();
		GL11.glRotatef(90, 0, 1, 0);
		GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
		
		// Top
		block.setBlockBounds(0F, 0.9F, 0F, 1F, 1F, 1F);
		renderer.setRenderBoundsFromBlock(block);
		renderAllSides(block, metadata, renderer);
		
		// Legs
		block.setBlockBounds(0F, 0F, 0F, 0.2F, 0.9F, 0.2F);
		renderer.setRenderBoundsFromBlock(block);
		renderAllSides(block, metadata, renderer);
		
		block.setBlockBounds(0.8F, 0F, 0F, 1F, 0.9F, 0.2F);
		renderer.setRenderBoundsFromBlock(block);
		renderAllSides(block, metadata, renderer);
		
		block.setBlockBounds(0F, 0F, 0.8F, 0.2F, 0.9F, 1F);
		renderer.setRenderBoundsFromBlock(block);
		renderAllSides(block, metadata, renderer);
		
		block.setBlockBounds(0.8F, 0F, 0.8F, 1F, 0.9F, 1F);
		renderer.setRenderBoundsFromBlock(block);
		renderAllSides(block, metadata, renderer);
		
		GL11.glPopMatrix();
	}
	
	private void renderAllSides(Block block, int metadata, RenderBlocks renderer) {
		Tessellator tessellator = Tessellator.instance;
		
		tessellator.startDrawingQuads();
		tessellator.setNormal(-1F, 0F, 0F);
		renderer.renderFaceXNeg(block, 0, 0, 0, block.getIcon(4, metadata));
		tessellator.draw();
		
		tessellator.startDrawingQuads();
		tessellator.setNormal(1F, 0F, 0F);
		renderer.renderFaceXPos(block, 0, 0, 0, block.getIcon(5, metadata));
		tessellator.draw();
		
		tessellator.startDrawingQuads();
		tessellator.setNormal(0F, -1F, 0F);
		renderer.renderFaceYNeg(block, 0, 0, 0, block.getIcon(0, metadata));
		tessellator.draw();
		
		tessellator.startDrawingQuads();
		tessellator.setNormal(0F, 1F, 0F);
		renderer.renderFaceYPos(block, 0, 0, 0, block.getIcon(1, metadata));
		tessellator.draw();
		
		tessellator.startDrawingQuads();
		tessellator.setNormal(0F, 0F, -1F);
		renderer.renderFaceZNeg(block, 0, 0, 0, block.getIcon(2, metadata));
		tessellator.draw();
		
		tessellator.startDrawingQuads();
		tessellator.setNormal(0F, 0F, 1F);
		renderer.renderFaceZPos(block, 0, 0, 0, block.getIcon(3, metadata));
		tessellator.draw();
	}
	
	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
		// Top
		block.setBlockBounds(0F, 0.9F, 0F, 1F, 1F, 1F);
		renderer.setRenderBoundsFromBlock(block);
		renderer.renderStandardBlock(block, x, y, z);
		
		// Legs
			block.setBlockBounds(0F, 0F, 0F, 0.2F, 0.9F, 0.2F);
			renderer.setRenderBoundsFromBlock(block);
			renderer.renderStandardBlock(block, x, y, z);
			
			block.setBlockBounds(0.8F, 0F, 0F, 1F, 0.9F, 0.2F);
			renderer.setRenderBoundsFromBlock(block);
			renderer.renderStandardBlock(block, x, y, z);
			
			block.setBlockBounds(0F, 0F, 0.8F, 0.2F, 0.9F, 1F);
			renderer.setRenderBoundsFromBlock(block);
			renderer.renderStandardBlock(block, x, y, z);
			
			block.setBlockBounds(0.8F, 0F, 0.8F, 1F, 0.9F, 1F);
			renderer.setRenderBoundsFromBlock(block);
			renderer.renderStandardBlock(block, x, y, z);
		
		return true;
	}
	
	@Override
	public boolean shouldRender3DInInventory() {
		return true;
	}
	
	@Override
	public int getRenderId() {
		return id;
	}
	
}
