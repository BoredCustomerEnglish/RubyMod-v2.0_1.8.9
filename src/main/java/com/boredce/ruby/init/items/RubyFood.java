package com.boredce.ruby.init.items;

import com.boredce.ruby.BoredCEsRubyMod;

import net.minecraft.item.ItemFood;

public class RubyFood extends ItemFood{

	public RubyFood(int amount, float saturation, boolean isWolfFood) {
		super(amount, saturation, isWolfFood);
		this.setCreativeTab(BoredCEsRubyMod.tabRuby);
	}

}
