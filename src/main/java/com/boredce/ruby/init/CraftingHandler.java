package com.boredce.ruby.init;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CraftingHandler {

	public static void CraftingRegistry()
	{
		/** Ore Block Recipes */
		GameRegistry.addRecipe(new ItemStack(RubyBlocks.ruby_block), new Object[]{"###","###","###",'#',RubyItems.ruby});
		GameRegistry.addSmelting(new ItemStack(RubyItems.ruby), new ItemStack(RubyBlocks.ruby_ore), 0.0F);
		
		/** Main Item Recipes */
		GameRegistry.addShapelessRecipe(new ItemStack(RubyItems.ruby, 9), new Object[]{RubyBlocks.ruby_block});
		GameRegistry.addRecipe(new ItemStack(RubyItems.ruby), new Object[]{"###","###","###",'#',RubyItems.ruby_nugget});
		GameRegistry.addShapelessRecipe(new ItemStack(RubyItems.ruby_nugget, 9), new Object[]{RubyItems.ruby});
		GameRegistry.addRecipe(new ItemStack(RubyItems.ruby_apple), new Object[]{"###","#@#","###",'#',RubyItems.ruby, '@',Items.apple});
		GameRegistry.addRecipe(new ItemStack(RubyItems.ruby_apple_ench), new Object[]{"###","#@#","###",'#',RubyBlocks.ruby_block, '@',Items.apple});
		GameRegistry.addRecipe(new ItemStack(RubyItems.ruby_carrot), new Object[]{"###","#@#","###",'#',RubyItems.ruby_nugget, '@',Items.carrot});
		GameRegistry.addRecipe(new ItemStack(RubyItems.ruby_pearl, 3), new Object[]{"###","#@#","###",'#',RubyItems.ruby_nugget, '@',RubyItems.ruby});
		
		/** Armor Item Recipes */
		GameRegistry.addRecipe(new ItemStack(RubyItems.ruby_helmet), new Object[]{"###","# #", '#',RubyItems.ruby});
		GameRegistry.addRecipe(new ItemStack(RubyItems.ruby_chestplate), new Object[]{"# #","###", "###", '#',RubyItems.ruby});
		GameRegistry.addRecipe(new ItemStack(RubyItems.ruby_leggings), new Object[]{"###","# #", "# #", '#',RubyItems.ruby});
		GameRegistry.addRecipe(new ItemStack(RubyItems.ruby_boots), new Object[]{"# #","# #", '#',RubyItems.ruby});
		
		/** Tool Item Recipes */
		GameRegistry.addRecipe(new ItemStack(RubyItems.ruby_sword), new Object[]{"@","@","#",'@',RubyItems.ruby,'#',Items.stick});
		GameRegistry.addRecipe(new ItemStack(RubyItems.ruby_shovel), new Object[]{"@","#","#",'@',RubyItems.ruby,'#',Items.stick});
		GameRegistry.addRecipe(new ItemStack(RubyItems.ruby_axe), new Object[]{"@@","@#"," #",'@',RubyItems.ruby,'#',Items.stick});
		GameRegistry.addRecipe(new ItemStack(RubyItems.ruby_axe), new Object[]{"@@","#@","# ",'@',RubyItems.ruby,'#',Items.stick});
		GameRegistry.addRecipe(new ItemStack(RubyItems.ruby_hoe), new Object[]{"@@"," #"," #",'@',RubyItems.ruby,'#',Items.stick});
		GameRegistry.addRecipe(new ItemStack(RubyItems.ruby_hoe), new Object[]{"@@","# ","# ",'@',RubyItems.ruby,'#',Items.stick});
		GameRegistry.addRecipe(new ItemStack(RubyItems.ruby_pickaxe), new Object[]{"@@@"," # "," # ",'@',RubyItems.ruby,'#',Items.stick});
	}
}