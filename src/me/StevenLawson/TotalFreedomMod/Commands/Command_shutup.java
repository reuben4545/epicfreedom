package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.SENIOR, source = SourceType.BOTH)
@CommandParameters(description = "Shut the player up", usage = "/<command> <playername>")
public class Command_shutup extends TFM_Command
{

	@Override
	public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole) {
		  if (args.length == 0)
	        {
	            return false;
	        }

	        final Player player = getPlayer(args[0]);

	        if (player == null)
	        {
	            playerMsg(TotalFreedomMod.PLAYER_NOT_FOUND, ChatColor.RED);
	            return true;
	        }
	        player.sendMessage(ChatColor.RED + "Now shut the fuck up will ya?");
	        player.setHealth(0);
	        final Location targetPos = player.getLocation();
	        for (int x = -1; x <= 1; x++)
	        {
	            for (int z = -1; z <= 1; z++)
	            {
	                final Location strike_pos = new Location(targetPos.getWorld(), targetPos.getBlockX() + x, targetPos.getBlockY(), targetPos.getBlockZ() + z);
	                targetPos.getWorld().strikeLightning(strike_pos);
	            }
	        }
		return true;
	}

}
