package de.roboticbrain.vswe.modelanatomy.assignment.entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityDroid extends Entity {
	
	float interpolatedArm = 0;
	
	public EntityDroid(World world) {
		super(world);
		setSize(0.5F, 0.75F);
	}
	
	// Keeps track of upper arm rotation
	private static final int UP_ARM_WATCHER_ID = 10;
	
	// Indirectly controls the rotation of the lower arm
	private static final int WAVE_WATCHER_ID = 11;
	
	// Head Rotation
	private static final int HEAD_WATCHER_ID = 12;
	
	@Override
	protected void entityInit() {
		dataWatcher.addObject(UP_ARM_WATCHER_ID, (float)0);
		dataWatcher.addObject(WAVE_WATCHER_ID, (float)0);
		dataWatcher.addObject(HEAD_WATCHER_ID, (float)0);
	}
	
	@Override
	protected void readEntityFromNBT(NBTTagCompound nbttagcompound) {
		// Do not save animations to NBT for easier testing
	}
	
	@Override
	protected void writeEntityToNBT(NBTTagCompound nbttagcompound) {
		// Do not save animations to NBT for easier testing
	}
	
	@Override
	public void onUpdate() {
		super.onUpdate();
		
		if (!worldObj.isRemote) {
			// On server side update animation state
			
			// Head position
			dataWatcher.updateObject(HEAD_WATCHER_ID, (float)(dataWatcher.func_111145_d(HEAD_WATCHER_ID) + 0.01F));
			
			// Arm position
			if (dataWatcher.func_111145_d(WAVE_WATCHER_ID) > 0) {
				dataWatcher.updateObject(UP_ARM_WATCHER_ID, (float)(Math.max(-Math.PI / 2, dataWatcher.func_111145_d(UP_ARM_WATCHER_ID) - 0.05F)));
				
				if (dataWatcher.func_111145_d(UP_ARM_WATCHER_ID) <= -(Math.PI / 2F)) {
					dataWatcher.updateObject(WAVE_WATCHER_ID, (float)(dataWatcher.func_111145_d(WAVE_WATCHER_ID) - 0.1F));
				}
			} else {
				float upArm = dataWatcher.func_111145_d(UP_ARM_WATCHER_ID);
				if (upArm < 0) {
					dataWatcher.updateObject(UP_ARM_WATCHER_ID, Math.min(0, upArm + 0.05F));
				}
			}
		} else {
			// On Client side smooth out arm motion
			// still not perfect but enough to hide the jumpy transition from linear to sine motion
			float actualPosition;
			// Calculate actual position
			if (dataWatcher.func_111145_d(UP_ARM_WATCHER_ID) > -(Math.PI / 2F)) {
				actualPosition = 0;
			} else {
				actualPosition = (float) (Math.sin(dataWatcher.func_111145_d(WAVE_WATCHER_ID)) - Math.PI / 2);
			}
			
			// Minimize error between current and actual position
			if (actualPosition > interpolatedArm) {
				interpolatedArm = Math.min(actualPosition, interpolatedArm + 0.1F);
			} else {
				interpolatedArm = Math.max(actualPosition, interpolatedArm - 0.1F);
			}
		}
		
		setPosition(posX + motionX, posY + motionY, posZ + motionZ);
	}
	
	@Override
	public boolean func_130002_c(EntityPlayer par1EntityPlayer) {
		if (!worldObj.isRemote) {
			float wave = dataWatcher.func_111145_d(WAVE_WATCHER_ID);
			// prevent the user from adding to much time to the wave timer
			if (wave <= 30F) {
				// has to be multiple of 2PI to prevent "animation jump" while waving
				// sin(x) == sin(2PI + x)
				dataWatcher.updateObject(WAVE_WATCHER_ID, (float)(wave + Math.PI * 2));
				System.out.println("Clicked!! " + dataWatcher.func_111145_d(WAVE_WATCHER_ID));
			}
		}
		
		return true;
	}
	
	@Override
	public AxisAlignedBB getBoundingBox() {
		return boundingBox;
	}
	
	@Override
	public AxisAlignedBB getCollisionBox(Entity entity) {
		return entity.boundingBox;
	}
	
	@Override
	public boolean canBeCollidedWith() {
		return !isDead;
	}
	
	@Override
	public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
		setDead();
		return true;
	}
	
	/**
	 * Returns head rotation
	 * @return
	 */
	public float getHeadRotation() {
		return dataWatcher.func_111145_d(HEAD_WATCHER_ID);
	}
	
	/**
	 * Returns upper arm rotation
	 * @return
	 */
	public float getUpperArmRotation() {
		return (float)dataWatcher.func_111145_d(UP_ARM_WATCHER_ID);
	}
	
	/**
	 * returns interpolated lower arm rotation
	 * @return
	 */
	public float getLowerArmRotation() {
		return interpolatedArm;
	}
	
}
