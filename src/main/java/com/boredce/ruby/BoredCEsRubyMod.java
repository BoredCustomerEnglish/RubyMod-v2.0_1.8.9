package com.boredce.ruby;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.boredce.ruby.init.CraftingHandler;
import com.boredce.ruby.init.RubyAchievements;
import com.boredce.ruby.init.RubyBlocks;
import com.boredce.ruby.init.RubyEntities;
import com.boredce.ruby.init.RubyItems;
import com.boredce.ruby.init.RubyTab;
import com.boredce.ruby.init.world.RubyWorldGen;
import com.boredce.ruby.proxy.CommonProxy;
import com.boredce.ruby.stats.CraftingEvents;
import com.boredce.ruby.stats.PlayerEvents;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION, acceptedMinecraftVersions = Reference.MC_VERSIONS)
public class BoredCEsRubyMod {
	
	public static final CreativeTabs tabRuby = new RubyTab("ruby_tab");
	
	@Instance(Reference.MOD_ID)
	public static BoredCEsRubyMod instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		/** Item and Block: Init and Registry */
		RubyItems.init();
		RubyItems.register();
		RubyBlocks.init();
		RubyBlocks.register();
		
		/** Achievements */
		RubyAchievements.loadAchievements();
		RubyAchievements.registerPage();
		
		/** Entity Registry */
		RubyEntities.preInit();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		/** Rendering Registry */
		proxy.registerRenders();
		
		/** Crafting Registry */
		CraftingHandler.CraftingRegistry();
		
		/** Ruby Generator Registry */
		GameRegistry.registerWorldGenerator(new RubyWorldGen(), 0);
		
		/** Event Registry */
		FMLCommonHandler.instance().bus().register(new PlayerEvents());
		FMLCommonHandler.instance().bus().register(new CraftingEvents());
	}
}
