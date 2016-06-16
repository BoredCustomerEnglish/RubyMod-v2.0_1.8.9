package com.boredce.ruby.init.world;

import java.util.Random;

import com.boredce.ruby.init.RubyBlocks;

import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class RubyWorldGen implements IWorldGenerator{

	private WorldGenerator gen_ruby_ore, gen_ruby;
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.getDimensionId()) {
		case 0:
			this.runGenerator(this.gen_ruby, world, random, chunkX, chunkZ, 10, 0, 16);
			this.runGenerator(this.gen_ruby_ore, world, random, chunkX, chunkZ, 20, 0, 64);
			break;
		case -1:
			break;
		case 1:
			break;
		}
	}

	public RubyWorldGen() {
		
		this.gen_ruby_ore = new WorldGenMinable(RubyBlocks.ruby_ore.getDefaultState(), 8);
		this.gen_ruby = new WorldGenSingleMinable(RubyBlocks.ruby_ore.getDefaultState());
		
	}
	
	private void runGenerator(WorldGenerator generator, World world, Random rand, int chunk_X, int chunk_Z, int chancesToSpawn, int minHeight, int maxHeight) {
	    if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight)
	        throw new IllegalArgumentException("Illegal Height Arguments for WorldGenerator");

	    int heightDiff = maxHeight - minHeight + 1;
	    for (int i = 0; i < chancesToSpawn; i ++) {
	        int x = chunk_X * 16 + rand.nextInt(16);
	        int y = minHeight + rand.nextInt(heightDiff);
	        int z = chunk_Z * 16 + rand.nextInt(16);
	        generator.generate(world, rand, new BlockPos(x, y, z));
	    }
	}
	
	
}
