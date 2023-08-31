package cmds;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class CmdFakeAdvancement implements CommandExecutor {
	
	JavaPlugin lplugin;
	
	public CmdFakeAdvancement(JavaPlugin plugin) {
		lplugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		CommandSender console = Bukkit.getConsoleSender();
		
		java.util.logging.Logger logger = lplugin.getLogger();
		
		String username = args[0];
		String[] advancementArgsList = args;
		String advancementDetailsFinal = "";
		
		
		int index = 0;
		for (String arg : advancementArgsList) {
			if (index > 0) {
				advancementDetailsFinal += arg + " ";
			}
			index++;
		}
		
		String[] argsFinal = advancementDetailsFinal.split(",");
		
		// this is pure vomit to look at wtf have i done
		String tellrawCommand = "tellraw @a [{\"text\":\"" + username + " has made the advancement \",\"color\":\"white\"},{\"text\":\"[" 
				+ argsFinal[0] + "]\",\"color\":\"green\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"" + argsFinal[0]
						+ "\",\"color\":\"green\"},{\"text\":\"\\n" + argsFinal[1] + "\",\"color\":\"white\"}]}}]";
		
		logger.info(tellrawCommand);
		logger.info("Command length : " + tellrawCommand.length());
		
		Bukkit.dispatchCommand(console, tellrawCommand);
		
		return true;
	}

}
