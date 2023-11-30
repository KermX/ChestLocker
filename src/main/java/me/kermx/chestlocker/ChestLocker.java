package me.kermx.chestlocker;

import org.bukkit.plugin.java.JavaPlugin;

public final class ChestHandler extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(ChestHandler, this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
