package com.boredce.ruby.init.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class RubyApple extends RubyFood {

	public RubyApple(int amount, float saturation, boolean isWolfFood) {
		super(amount, saturation, isWolfFood);
		this.setAlwaysEdible();
	}

    public void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player)
    {
    	player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 600, 4));
    	player.addPotionEffect(new PotionEffect(Potion.resistance.id, 6000, 0));
    	player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 6000, 0));
    	player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 6000, 5));
    	player.addPotionEffect(new PotionEffect(Potion.jump.id, 6000, 5));
    	player.addPotionEffect(new PotionEffect(Potion.nightVision.id, 6000, 5));
    	player.addPotionEffect(new PotionEffect(Potion.waterBreathing.id, 6000, 5));
    	player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 6000, 5));
    	player.addPotionEffect(new PotionEffect(Potion.heal.id, 6000, 5));
    	player.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 6000, 5));
    }
    
    public boolean hasEffect(ItemStack stack)
	{
		return true;
	}
    
    @Override
    public EnumRarity getRarity(ItemStack stack) {
    	return EnumRarity.EPIC;
    }
}