package com.boredce.ruby.init.blocks;

import java.util.Random;

import com.boredce.ruby.init.RubyItems;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class RubyOre extends BlockMod {

	public RubyOre(Material materialIn, String name) {
		super(materialIn, name);
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return RubyItems.ruby;
	}
	
	@Override
	public int quantityDropped(IBlockState state, int fortune, Random random) {
		return 3;
	}
	
	@Override
	public boolean canSilkHarvest(World world, BlockPos pos, IBlockState state, EntityPlayer player) {
		return true;
	}
	
	@Override
	public int getExpDrop(IBlockAccess world, BlockPos pos, int fortune) {
		return 10;
	}
}
