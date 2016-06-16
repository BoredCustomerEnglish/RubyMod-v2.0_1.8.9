package com.boredce.ruby.stats;

import com.boredce.ruby.init.RubyAchievements;
import com.boredce.ruby.init.RubyItems;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;

public class CraftingEvents
{

	@SubscribeEvent
	public void onCrafted(ItemCraftedEvent event)
	{
		if (event.crafting.getItem() == RubyItems.ruby_sword)
		{
			event.player.triggerAchievement(RubyAchievements.ruby_warrior);
			return;
		}
		
		if (event.crafting.getItem() == RubyItems.ruby_shovel)
		{
			event.player.triggerAchievement(RubyAchievements.ruby_digger);
			return;
		}
		
		if (event.crafting.getItem() == RubyItems.ruby_hoe)
		{
			event.player.triggerAchievement(RubyAchievements.ruby_farmer);
			return;
		}
		
		if (event.crafting.getItem() == RubyItems.ruby_pickaxe)
		{
			event.player.triggerAchievement(RubyAchievements.ruby_miner);
			return;
		}
		
		if (event.crafting.getItem() == RubyItems.ruby_axe)
		{
			event.player.triggerAchievement(RubyAchievements.ruby_chopper);
			return;
		}
	}
}
