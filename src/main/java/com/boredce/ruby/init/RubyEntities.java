package com.boredce.ruby.init;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelIronGolem;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;

import com.boredce.ruby.BoredCEsRubyMod;
import com.boredce.ruby.Reference;
import com.boredce.ruby.entity.EntityRubyGolem;
import com.boredce.ruby.entity.EntityRubyPearl;

public class RubyEntities
{

	public static void preInit()
	{
		registerEntity();
	}
	
	public static void registerEntity()
	{
		createEntity(EntityRubyPearl.class, "RubyPearl");
		createMob(EntityRubyGolem.class, "VillagerGolemRuby", 0xFF2929, 0xAB1818);
	}
	
	public static void registerRenders()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityRubyPearl.class, new RenderSnowball(Minecraft.getMinecraft().getRenderManager(), RubyItems.ruby_pearl, Minecraft.getMinecraft().getRenderItem()));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityRubyGolem.class, new RenderLiving(Minecraft.getMinecraft().getRenderManager(), new ModelIronGolem(), 0)
		{
			protected ResourceLocation getEntityTexture(Entity entityIn)
			{
				return new ResourceLocation(Reference.MOD_ID + ":textures/entity/ruby_golem.png");
			}});
	}
	
	public static void createMob(Class <? extends Entity> entityClass, String entityName, int solidColor, int spotColor)
	{
		int randomId = EntityRegistry.findGlobalUniqueEntityId();
		EntityRegistry.registerGlobalEntityID(entityClass, entityName, randomId);
		EntityRegistry.registerModEntity(entityClass, entityName, randomId, BoredCEsRubyMod.instance, 64, 1, true);
		createEgg(randomId, solidColor, spotColor);
	}
	
	public static void createEntity(Class <? extends Entity> entityClass, String entityName)
	{
		int randomID = EntityRegistry.findGlobalUniqueEntityId();
		EntityRegistry.registerGlobalEntityID(entityClass, entityName, randomID);
		EntityRegistry.registerModEntity(entityClass, entityName, randomID, BoredCEsRubyMod.instance, 64, 1, true);
	}
	
	public static void createEgg(int randomId, int solidColor, int spotColor)
	{
		EntityList.entityEggs.put(Integer.valueOf(randomId), new EntityList.EntityEggInfo(randomId, solidColor, spotColor));
	}
}
