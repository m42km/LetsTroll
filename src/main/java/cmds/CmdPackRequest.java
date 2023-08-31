package cmds;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CmdPackRequest implements CommandExecutor {
	
	public String prefix = ChatColor.GRAY + "[" + 
			ChatColor.WHITE + ChatColor.BOLD + "LetsTroll" + ChatColor.RESET + 
			ChatColor.GRAY + "] " + ChatColor.GREEN;
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		// https://download2391.mediafire.com/uijiv6tm86vg/nn5lylpay1fans1/Cursed+Craft+Regular+Text.zip
		String playerName = args[0];
		Player player = Bukkit.getPlayer(playerName);
		
		try {
			if (args.length > 1) {
				player.setResourcePack(args[0]);
			} else {
				player.setResourcePack("https://download2391.mediafire.com/uijiv6tm86vg/nn5lylpay1fans1/Cursed+Craft+Regular+Text.zip");
			}
		} catch (Exception e) {
			sender.sendMessage(prefix + ChatColor.RED + "Couldn't send the pack, player is offline/doesn't exist.");
		}
		return true;
	}

}
