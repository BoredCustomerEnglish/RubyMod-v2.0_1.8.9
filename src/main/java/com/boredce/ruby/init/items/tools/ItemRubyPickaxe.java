package com.boredce.ruby.init.items.tools;

import com.boredce.ruby.BoredCEsRubyMod;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemRubyPickaxe extends ItemPickaxe {

	public ItemRubyPickaxe(ToolMaterial material, String name) {
		super(material);
		this.setUnlocalizedName(name);
		this.setCreativeTab(BoredCEsRubyMod.tabRuby);
	}

	@Override
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.UNCOMMON;
	}
	
	@Override
	public void onCreated(ItemStack stack, World worldIn, EntityPlayer playerIn) {
		stack.addEnchantment(Enchantment.fortune, 5);
		stack.addEnchantment(Enchantment.knockback, 2);
		stack.addEnchantment(Enchantment.unbreaking, 5);
	}
	
	@Override
	public boolean isRepairable() {
		return true;
	}
}
