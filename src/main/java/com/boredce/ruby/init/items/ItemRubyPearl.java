package com.boredce.ruby.init.items;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import com.boredce.ruby.entity.EntityRubyPearl;

public class ItemRubyPearl extends RubyItem {

	public ItemRubyPearl(String name)
	{
		super(name);
	}

	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
	{	
		--itemStackIn.stackSize;
		worldIn.playSoundAtEntity(playerIn, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

        if (!worldIn.isRemote)
        {
                worldIn.spawnEntityInWorld(new EntityRubyPearl(worldIn, playerIn));
        }

            playerIn.triggerAchievement(StatList.objectUseStats[Item.getIdFromItem(this)]);
            return itemStackIn;
	}

	@Override
	public void addInformation(ItemStack itemStackIn, EntityPlayer playerIn, List<String> list, boolean bool)
	{
		list.add(EnumChatFormatting.RED + "Now, you can use it in Creative Mode, too!!!");
	}
}
