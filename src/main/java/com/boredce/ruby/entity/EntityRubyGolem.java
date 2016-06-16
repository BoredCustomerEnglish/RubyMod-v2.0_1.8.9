package com.boredce.ruby.entity;

import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.item.Item;
import net.minecraft.world.World;

import com.boredce.ruby.init.RubyBlocks;
import com.boredce.ruby.init.RubyItems;

public class EntityRubyGolem extends EntityIronGolem
{
	public EntityRubyGolem(World worldIn)
	{
		super(worldIn);
	}
	
	public EntityRubyGolem(World worldIn, double x, double y, double z)
	{
		this(worldIn);
		this.setPosition(x,y,z);
	}
	
	@Override
	public void dropFewItems(boolean bool, int integer)
	{
		this.dropItem(RubyItems.ruby, 5);
		this.dropItem(Item.getItemFromBlock(RubyBlocks.ruby_block), 1);
	}
	
	@Override
	public Item getDropItem()
	{
		return RubyItems.ruby;
	}
}