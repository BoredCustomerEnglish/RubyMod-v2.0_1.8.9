package com.boredce.ruby.init;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.boredce.ruby.Reference;
import com.boredce.ruby.init.blocks.BlockMod;
import com.boredce.ruby.init.blocks.RubyBlock;
import com.boredce.ruby.init.blocks.RubyOre;

public class RubyBlocks {

	/** Ore Blocks */
	public static BlockMod ruby_block, ruby_ore;
	
	public static void init()
	{
		/** Ore Blocks Init */
		ruby_block = new RubyBlock(Material.iron, "blockruby");
		ruby_ore = new RubyOre(Material.rock, "blockrubyore");
	}

	public static void register()
	{
		/** Ore Blocks Registry */
		GameRegistry.registerBlock(ruby_block, ruby_block.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(ruby_ore, ruby_ore.getUnlocalizedName().substring(5));
	}

	public static void registerRenders()
	{
		/** Ore Blocks Rendering */
		registerRender(ruby_block);
		registerRender(ruby_ore);
	}

	public static void registerRender(Block block)
	{
		Item item = Item.getItemFromBlock(block);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
}
