package cmds;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.EntityEffect;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class CmdFakeCreeper implements CommandExecutor {
	
	JavaPlugin plugin;
	public String prefix = ChatColor.GRAY + "[" + 
			ChatColor.WHITE + ChatColor.BOLD + "LetsTroll" + ChatColor.RESET + 
			ChatColor.GRAY + "] " + ChatColor.GREEN;
	
	public CmdFakeCreeper(JavaPlugin jPlugin) {
		plugin = jPlugin; // fix for RunTaskLater()
	}
	
	public void FakeExplosion(Player player, Location playerLoc) {
		player.playSound(playerLoc, Sound.ENTITY_DRAGON_FIREBALL_EXPLODE, 0, 0);
		player.spawnParticle(Particle.EXPLOSION_HUGE, playerLoc.getX() + 6, playerLoc.getY(), playerLoc.getZ() + 2, 1);
		player.playEffect(EntityEffect.HURT_EXPLOSION);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		String playerName = args[0];
		Player player = Bukkit.getPlayer(playerName);
		
		try {
			Location playerLoc = player.getLocation();
			
			// Play creeper hiss
			player.playSound(playerLoc, Sound.ENTITY_CREEPER_PRIMED, 1, 1);
			
			if (args.length < 2) {
				Bukkit.getScheduler().runTaskLater(plugin, () -> FakeExplosion(player, playerLoc), 20);
			} else {
				Bukkit.getScheduler().runTaskLater(plugin, () -> FakeExplosion(player, playerLoc), Integer.parseInt(args[1]));
			}
			
		} catch (Exception e) {
			
		}
		
		return true;
	}

}
