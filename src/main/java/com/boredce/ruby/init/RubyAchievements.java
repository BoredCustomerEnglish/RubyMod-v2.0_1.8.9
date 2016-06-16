package com.boredce.ruby.init;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

public class RubyAchievements
{

	public static Achievement install_mod;
	public static Achievement ruby_warrior;
	public static Achievement ruby_digger;
	public static Achievement ruby_miner;
	public static Achievement ruby_farmer;
	public static Achievement ruby_chopper;
	
	public static AchievementPage page;
	
	public static void loadAchievements()
	{
		install_mod = new Achievement("achievement.install_mod", "install_mod", 0, 0, new ItemStack(RubyItems.customer), null).setSpecial();
		install_mod.registerStat();
		
		ruby_warrior = new Achievement("achievement.ruby_warrior", "ruby_warrior", 1, 0, new ItemStack(RubyItems.ruby_sword), null).registerStat();
		ruby_digger = new Achievement("achievement.ruby_digger", "ruby_digger", 2, 0, new ItemStack(RubyItems.ruby_shovel), null).registerStat();
		ruby_miner = new Achievement("achievement.ruby_miner", "ruby_miner", 3, 0, new ItemStack(RubyItems.ruby_pickaxe), null).registerStat();
		ruby_farmer = new Achievement("achievement.ruby_farmer", "ruby_farmer", 4, 0, new ItemStack(RubyItems.ruby_hoe), null).registerStat();
		ruby_chopper = new Achievement("achievement.ruby_chopper", "ruby_chopper", 5, 0, new ItemStack(RubyItems.ruby_axe), null).registerStat();
		
		page = new AchievementPage("Ruby Mod", install_mod, ruby_warrior, ruby_digger, ruby_miner, ruby_farmer, ruby_chopper);
	}

	public static void registerPage()
	{
		AchievementPage.registerAchievementPage(page);
	}
}
