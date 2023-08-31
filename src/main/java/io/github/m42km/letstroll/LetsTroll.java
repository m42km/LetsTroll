package io.github.m42km.letstroll;

import org.bukkit.plugin.java.JavaPlugin;

import cmds.*;

public final class LetsTroll extends JavaPlugin {
	
	// Plugin enabling and disabling messages
	@Override
    public void onEnable() {
		getLogger().info("Plugin successfully enabled, happy trolling ;)");
		
		this.getCommand("woosh").setExecutor(new CmdWoosh(this)); // to access the main plugin
		this.getCommand("fakecreeper").setExecutor(new CmdFakeCreeper(this));
		this.getCommand("packrequest").setExecutor(new CmdPackRequest());
		this.getCommand("fakeadvance").setExecutor(new CmdFakeAdvancement(this));
    }
    @Override
    public void onDisable() {
    	getLogger().info("Plugin disabled, goodbye!");
    }
}