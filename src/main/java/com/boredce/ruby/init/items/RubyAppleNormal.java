package com.boredce.ruby.init.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class RubyAppleNormal extends RubyFood{

	public RubyAppleNormal(int amount, float saturation, boolean isWolfFood) {
		super(amount, saturation, isWolfFood);
		this.setAlwaysEdible();
	}

	public void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player)
    {
    	player.addPotionEffect(new PotionEffect(Potion.absorption.id, 600, 4));
    }
	
	public boolean hasEffect(ItemStack stack)
	{
		return false;
	}
	
	@Override
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.RARE;
	}
}