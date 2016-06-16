package com.boredce.ruby.init;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.boredce.ruby.Reference;
import com.boredce.ruby.init.items.ItemRubyArmor;
import com.boredce.ruby.init.items.ItemRubyPearl;
import com.boredce.ruby.init.items.RubyApple;
import com.boredce.ruby.init.items.RubyAppleNormal;
import com.boredce.ruby.init.items.RubyFood;
import com.boredce.ruby.init.items.RubyItem;
import com.boredce.ruby.init.items.tools.ItemRubyAxe;
import com.boredce.ruby.init.items.tools.ItemRubyHoe;
import com.boredce.ruby.init.items.tools.ItemRubyPickaxe;
import com.boredce.ruby.init.items.tools.ItemRubySpade;
import com.boredce.ruby.init.items.tools.ItemRubySword;

public class RubyItems
{
	/** Materials */
	public static Item.ToolMaterial ruby_tool = EnumHelper.addToolMaterial("ruby_tool", 4, 2000, 10.0F, 10.0F, 50);
	public static ItemArmor.ArmorMaterial ruby_armor = EnumHelper.addArmorMaterial("ruby_armor", Reference.MOD_ID + ":ruby", 5000, new int[]{10,10,10,10}, 50);
	
	/** Main Items */
	public static Item ruby, ruby_nugget, ruby_apple, ruby_apple_ench, ruby_carrot, ruby_pearl, customer;
	
	/** Armor Items */
	public static ItemArmor ruby_helmet, ruby_chestplate, ruby_leggings, ruby_boots;
	
	/** Tool Items */
	public static ItemSword ruby_sword;
	public static ItemAxe ruby_axe;
	public static ItemPickaxe ruby_pickaxe;
	public static ItemHoe ruby_hoe;
	public static ItemSpade ruby_shovel;
	
	public static void init()
	{
		/** Main Items Init */
		ruby = new RubyItem("itemruby");
		ruby_nugget = new RubyItem("itemrubynugget");
		ruby_apple = new RubyAppleNormal(4, 1.2F, false).setUnlocalizedName("itemrubyapple_0");
		ruby_apple_ench = new RubyApple(4, 1.2F, false).setUnlocalizedName("itemrubyapple_1");
		ruby_carrot = new RubyFood(20, 4.0F, true).setUnlocalizedName("itemrubycarrot");
		ruby_pearl = new ItemRubyPearl("itemrubypearl");
		customer = new Item().setUnlocalizedName("customer");
		
		/** Armor Items Init */
		ruby_helmet = new ItemRubyArmor(ruby_armor, 0, 0, "itemrubyhelmet");
		ruby_chestplate = new ItemRubyArmor(ruby_armor, 0, 1, "itemrubychestplate");
		ruby_leggings = new ItemRubyArmor(ruby_armor, 0, 2, "itemrubyleggings");
		ruby_boots = new ItemRubyArmor(ruby_armor, 0, 3, "itemrubyboots");
		
		/** Tool Items Init */
		ruby_sword = new ItemRubySword(ruby_tool, "itemrubysword");
		ruby_axe = new ItemRubyAxe(ruby_tool, "itemrubyaxe");
		ruby_hoe = new ItemRubyHoe(ruby_tool, "itemrubyhoe");
		ruby_pickaxe = new ItemRubyPickaxe(ruby_tool, "itemrubypickaxe");
		ruby_shovel = new ItemRubySpade(ruby_tool, "itemrubyshovel");
	}

	public static void register()
	{
		/** Main Items Registry */
		GameRegistry.registerItem(ruby, ruby.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(ruby_nugget, ruby_nugget.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(ruby_apple, ruby_apple.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(ruby_apple_ench, ruby_apple_ench.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(ruby_carrot, ruby_carrot.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(ruby_pearl, ruby_pearl.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(customer, customer.getUnlocalizedName().substring(5));
		
		/** Armor Items Registry */
		GameRegistry.registerItem(ruby_helmet, ruby_helmet.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(ruby_chestplate, ruby_chestplate.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(ruby_leggings, ruby_leggings.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(ruby_boots, ruby_boots.getUnlocalizedName().substring(5));
		
		/** Tool Items Registry */
		GameRegistry.registerItem(ruby_sword, ruby_sword.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(ruby_axe, ruby_axe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(ruby_hoe, ruby_hoe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(ruby_pickaxe, ruby_pickaxe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(ruby_shovel, ruby_shovel.getUnlocalizedName().substring(5));
	}

	public static void registerRenders()
	{
		/** Main Items Rendering as item */
		registerRender(ruby);
		registerRender(ruby_nugget);
		registerRender(ruby_apple);
		registerRender(ruby_apple_ench);
		registerRender(ruby_carrot);
		registerRender(ruby_pearl);
		registerRender(customer);
		
		/** Armor Items Rendering as item */
		registerRender(ruby_helmet);
		registerRender(ruby_chestplate);
		registerRender(ruby_leggings);
		registerRender(ruby_boots);
		
		/** Tool Items Rendering as item */
		registerRender(ruby_sword);
		registerRender(ruby_axe);
		registerRender(ruby_hoe);
		registerRender(ruby_pickaxe);
		registerRender(ruby_shovel);
	}

	public static void registerRender(Item item)
	{
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
}
