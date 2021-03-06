/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.StevenLawson.TotalFreedomMod.Commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.BOTH)
@CommandParameters(description = "Gives a player OP items.", usage = "/<command>")
public class Command_opitems extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (args.length > 1)
        {
            return false;
        }
           if (args.length == 0)
                 {
         	        final Player player = getPlayer(args[0]);
                    PlayerInventory inv = player.getInventory();
                    ItemStack sword = new ItemStack(Material.DIAMOND_SWORD, 1);
                    ItemStack chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
                    ItemStack leggings = new ItemStack(Material.DIAMOND_LEGGINGS, 1);
                    ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS, 1);
                    ItemStack helmet = new ItemStack(Material.DIAMOND_HELMET, 1);
                    ItemStack bow = new ItemStack(Material.BOW, 1);
                    for (Enchantment ench : Enchantment.values())
                    {
                        sword.addUnsafeEnchantment(ench, 10000);
                    }
                    for (Enchantment ench : Enchantment.values())
                    {
                        bow.addUnsafeEnchantment(ench, 10000);
                    }
                    inv.addItem(bow);
                    inv.addItem(sword);
                    for (Enchantment ench : Enchantment.values())
                    {
                        chestplate.addUnsafeEnchantment(ench, 10000);
                    }
                    for (Enchantment ench : Enchantment.values())
                    {
                        leggings.addUnsafeEnchantment(ench, 10000);
                    }
                    for (Enchantment ench : Enchantment.values())
                    {
                        boots.addUnsafeEnchantment(ench, 10000);
                    }
                    for (Enchantment ench : Enchantment.values())
                    {
                        helmet.addUnsafeEnchantment(ench, 10000);
                    }
                    inv.setHelmet(helmet);
                    inv.setBoots(boots);
                    inv.setLeggings(leggings);
                    inv.setChestplate(chestplate);
                    player.sendMessage(ChatColor.RED + "Op items have been placed in your inventory.");
                 }
       return true;
}
}
