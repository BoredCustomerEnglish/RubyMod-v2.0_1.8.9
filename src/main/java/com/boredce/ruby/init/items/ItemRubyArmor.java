package com.boredce.ruby.init.items;

import com.boredce.ruby.BoredCEsRubyMod;
import com.boredce.ruby.init.RubyItems;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemRubyArmor extends ItemArmor {

	public ItemRubyArmor(ArmorMaterial material, int renderIndex, int armorType, String name)
	{
		super(material, renderIndex, armorType);
		this.setUnlocalizedName(name);
		
		this.setCreativeTab(BoredCEsRubyMod.tabRuby);
	}

	@Override
	public boolean isRepairable()
	{
		return true;
	}
	
	@Override
	public void onArmorTick(World worldIn, EntityPlayer playerIn, ItemStack itemStackIn) {
		playerIn.addPotionEffect(new PotionEffect(Potion.resistance.id, 0, 1));
		playerIn.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 0, 1));
	}
	
	@Override
	public void onCreated(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
	{
		if(this == RubyItems.ruby_helmet)
		itemStackIn.addEnchantment(Enchantment.projectileProtection, 3);
		
		if(this == RubyItems.ruby_chestplate)
		itemStackIn.addEnchantment(Enchantment.protection, 3);
		
		if(this == RubyItems.ruby_leggings)
		itemStackIn.addEnchantment(Enchantment.thorns, 3);
		
		if(this == RubyItems.ruby_boots)
		itemStackIn.addEnchantment(Enchantment.featherFalling, 3);
	}
}
