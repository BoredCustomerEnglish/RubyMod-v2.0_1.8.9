package com.boredce.ruby.init.items;

import com.boredce.ruby.BoredCEsRubyMod;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class RubyItem extends Item{

	public RubyItem(String name) {
		this.setUnlocalizedName(name);
		this.setCreativeTab(BoredCEsRubyMod.tabRuby);
	}
}
