package cmds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.material.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
public class CmdTrap implements CommandExecutor {
	
	public JavaPlugin plugin;
	
	public CmdTrap(JavaPlugin jplugin) {
		plugin = jplugin;
	}
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		Player player = Bukkit.getPlayer(args[0]);
		Location playerLocation = player.getLocation();
		World world = player.getWorld();
		
		// Player location variables
		double pX = playerLocation.getX();
		double pY = playerLocation.getY();
		double pZ = playerLocation.getZ();
		
		
		List<Location> glassBlocks = new ArrayList<>(Arrays.asList(
				new Location(world, pX, pY + 2, pZ),
				new Location(world, pX + 1, pY, pZ),
				new Location(world, pX, pY, pZ + 1),
				new Location(world, pX + 1, pY + 1, pZ),
				new Location(world, pX, pY + 1, pZ + 1),
				new Location(world, pX, pY + 1, pZ - 1),
				new Location(world, pX - 1, pY, pZ - 1),
				new Location(world, pX - 1, pY, pZ - 1), // placeholders start here
				new Location(world, pX - 1, pY, pZ - 1)
				));
		
		// 
		player.getWorld().getBlockAt(playerLocation).setType(Material.GLASS);
		
		return true;
	}

}
