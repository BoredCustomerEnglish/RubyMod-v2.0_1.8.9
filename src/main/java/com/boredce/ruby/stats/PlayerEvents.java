package com.boredce.ruby.stats;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;

import com.boredce.ruby.Reference;
import com.boredce.ruby.init.RubyAchievements;

public class PlayerEvents
{

	@SubscribeEvent
	public void onPlayerLogin(PlayerLoggedInEvent event)
	{
		String arrow = "--> ";

		EntityPlayer playerIn = (EntityPlayer) event.player;
		
		ChatComponentText dashes = new ChatComponentText(EnumChatFormatting.YELLOW + "--------------------------------------------------");
		ChatComponentText prefix = new ChatComponentText(EnumChatFormatting.AQUA + arrow + "Thanks for installing BoredCE's Ruby Mod");
		ChatComponentText prefix_version = new ChatComponentText(EnumChatFormatting.GREEN + arrow + "Current Version of Mod is " + Reference.VERSION);
		ChatComponentText prefix_youtube = new ChatComponentText(EnumChatFormatting.RED + "[Youtube]: Bored Customer English - BCE!");
		ChatComponentText prefix_facebook = new ChatComponentText(EnumChatFormatting.BLUE + "[Facebook]: BoredCustomerEnglish");
		ChatComponentText prefix_email = new ChatComponentText(EnumChatFormatting.YELLOW + "[E-mail]: bored.customer.english@gmail.com");
		
		playerIn.addChatMessage(new ChatComponentText(EnumChatFormatting.YELLOW + playerIn.getName() + " joined to game."));
		playerIn.addChatMessage(dashes);
		playerIn.addChatMessage(prefix);
		playerIn.addChatMessage(prefix_version);
		playerIn.addChatMessage(prefix_youtube);
		playerIn.addChatMessage(prefix_facebook);
		playerIn.addChatMessage(prefix_email);
		playerIn.addChatMessage(dashes);
		
		playerIn.triggerAchievement(RubyAchievements.install_mod);
	}
}
