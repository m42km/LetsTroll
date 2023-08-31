package cmds;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.*;

public class CmdWoosh implements CommandExecutor {

	JavaPlugin plugin;
	
	public String prefix = ChatColor.GRAY + "[" + 
			ChatColor.WHITE + ChatColor.BOLD + "LetsTroll" + ChatColor.RESET + 
			ChatColor.GRAY + "] " + ChatColor.GREEN;
	
	public CommandSender console = Bukkit.getConsoleSender();
	
	public void LevitationEffect(Player player, int speeed) {
		player.removePotionEffect(PotionEffectType.LEVITATION); // remove the effect first!
		player.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 10*20, speeed));
	}
	
	public CmdWoosh(JavaPlugin jPlugin) {
		plugin = jPlugin; // to use RunTaskLater we need to provide the main plugin. pretty simple fix
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof Player) {
			if (args.length > 0) {
				
				String playerName = args[0];
				Player player = Bukkit.getPlayer(playerName);
				
				
				try {
					player.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 10*20, 5));
					player.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 10*20, 1));
					player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 10*20, 200));
					sender.sendMessage(prefix + "Wooshing " + ChatColor.ITALIC + player.getName() + ChatColor.RESET + ChatColor.GREEN + "...");
				} catch (Exception e) { // handle errors
					sender.sendMessage(prefix + ChatColor.RED + ChatColor.BOLD + "Player is not online/doesn't exist!");
					return true;
				}
				
				int time = 1;
				
				for (int i = 5; i <= 80; i = i + 2) { // add levitation easing effect, gradually becoming faster and faster
					
					time = time + 1;
					int speed = i;
					
					Bukkit.getScheduler().runTaskLater(plugin, () -> LevitationEffect(player, speed), 1 + time * 1);
					
				}
			} else {
				sender.sendMessage(prefix + ChatColor.RED + ChatColor.BOLD + "No player provided to woosh!");
			}
		}
		return true;
	}
}
 