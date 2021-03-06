package me.StevenLawson.TotalFreedomMod.Commands;

import java.util.Random;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import org.bukkit.Achievement;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

@CommandPermissions(level = AdminLevel.SENIOR, source = SourceType.BOTH)
@CommandParameters(description = "Gives people who are still alive da Kake.", usage = "/<command>")
public class Command_kake extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (!sender.getName().equals("tylerhyperHD") && !sender.getName().equals("KandyKake"))
        {
            sender.sendMessage(TotalFreedomMod.MSG_NO_PERMS);

            if (!senderIsConsole)
            {
                sender.setOp(false);
            }
            else
            {
                sender.sendMessage("You are not Kandy nor Kake. Stfu.");
            }
        StringBuilder output = new StringBuilder();
        Random randomGenerator = new Random();
        String[] words = TotalFreedomMod.KAKE_LYRICS.split(" ");
        for (String word : words)
        {
            String color_code = Integer.toHexString(1 + randomGenerator.nextInt(14));
            output.append(ChatColor.COLOR_CHAR).append(color_code).append(word).append(" ");
        }

        ItemStack heldItem = new ItemStack(Material.CAKE);
        ItemMeta heldItemMeta = heldItem.getItemMeta();
        heldItemMeta.setDisplayName((new StringBuilder()).append(ChatColor.WHITE).append("The ").append(ChatColor.BLUE).append("Kake").toString());
        heldItem.setItemMeta(heldItemMeta);

        for (Player player : server.getOnlinePlayers())
        {
            player.getInventory().setItem(player.getInventory().firstEmpty(), heldItem);
            player.awardAchievement(Achievement.MINE_WOOD);
            player.awardAchievement(Achievement.BUILD_WORKBENCH);
            player.awardAchievement(Achievement.BUILD_HOE);
            player.awardAchievement(Achievement.BAKE_CAKE);
        }

        TFM_Util.bcastMsg(output.toString());
        return true;
    }
        return true;
}
}