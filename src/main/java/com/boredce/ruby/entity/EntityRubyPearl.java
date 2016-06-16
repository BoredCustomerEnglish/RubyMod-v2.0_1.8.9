package com.boredce.ruby.entity;

import com.boredce.ruby.init.RubyItems;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityRubyPearl extends EntityThrowable
{
	private EntityLivingBase living;

	public EntityRubyPearl(World worldIn)
	{
		super(worldIn);
	}

	public EntityRubyPearl(World worldIn, EntityLivingBase living)
	{
		super(worldIn, living);
		this.living = living;
	}

	@SideOnly(Side.CLIENT)
	public EntityRubyPearl(World worldIn, double x, double y, double z)
	{
		super(worldIn, x, y, z);
	}

	@Override
	public void onImpact(MovingObjectPosition obj)
	{
		EntityLivingBase entitylivingbase = getThrower();

		if (obj.entityHit != null)
		{
			if (obj.entityHit == this.living)
			{
				return;
			}

			obj.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, entitylivingbase), 0.0F);
		}

		for (int i = 0; i < 32; ++i)
		{
			this.worldObj.spawnParticle(EnumParticleTypes.PORTAL, this.posX, this.posY + this.rand.nextDouble() * 2.0D, this.posZ, this.rand.nextGaussian(), 0.0D, this.rand.nextGaussian(), new int[0]);
		}

		if(this.worldObj.isRemote)
			return;
		
		if (entitylivingbase instanceof EntityPlayerMP)
		{
			EntityPlayerMP entityplayermp = (EntityPlayerMP) entitylivingbase;

			if ((entityplayermp.playerNetServerHandler.getNetworkManager().isChannelOpen())
					&& (entityplayermp.worldObj == this.worldObj)
					&& (!(entityplayermp.isPlayerSleeping())))
			{
				EnderTeleportEvent event = new EnderTeleportEvent(entityplayermp, this.posX, this.posY, this.posZ, 5.0F);
				if (!(MinecraftForge.EVENT_BUS.post(event)))
				{
					if ((this.rand.nextFloat() < 0.05F)
							&& (this.worldObj.getGameRules().getBoolean("doMobSpawning")))
					{
						EntityItem item = new EntityItem(worldObj, this.posX, this.posY + 1, this.posZ, new ItemStack(RubyItems.ruby_pearl));
						this.worldObj.spawnEntityInWorld(item);
					}

					if (entitylivingbase.isRiding())
					{
						entitylivingbase.mountEntity((Entity) null);
					}

					entitylivingbase.setPositionAndUpdate(event.targetX, event.targetY, event.targetZ);
					entitylivingbase.fallDistance = 0.0F;
					entitylivingbase.attackEntityFrom(DamageSource.fall, event.attackDamage);
				}
			}
		}
		else if (entitylivingbase != null)
		{
			entitylivingbase.setPositionAndUpdate(this.posX, this.posY, this.posZ);
			entitylivingbase.fallDistance = 0.0F;
		}

		setDead();
	}

	@Override
	public void onUpdate()
	{
		EntityLivingBase entitylivingbase = getThrower();

		if ((entitylivingbase != null) && (entitylivingbase instanceof EntityPlayer) && (!(entitylivingbase.isEntityAlive())))
		{
			setDead();
		}
		
		else
		{
			super.onUpdate();
		}
	}
}