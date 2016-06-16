package com.boredce.ruby.init.blocks;

import com.boredce.ruby.BoredCEsRubyMod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockMod extends Block{

	public BlockMod(Material materialIn, String name) {
		super(materialIn);
		this.setUnlocalizedName(name);
		this.setCreativeTab(BoredCEsRubyMod.tabRuby);
		this.setHardness(2.0F);
		this.setHarvestLevel("pickaxe", 2);
	}

}
