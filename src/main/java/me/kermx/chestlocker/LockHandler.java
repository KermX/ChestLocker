package me.kermx.chestlocker;

import com.palmergames.bukkit.towny.TownyAPI;
import com.palmergames.bukkit.towny.object.Town;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Chest;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class LockListener implements Listener {

    private final ChestLocker plugin;
    private final Map<UUID, Location> locationMap = new HashMap<>();
    private File chestLocationDataFile;
    private FileConfiguration chestLocationDataConfig;

    public LockListener(ChestLocker plugin){
        this.plugin = plugin;
        this.chestLocationDataFile = new File(plugin.getDataFolder(), "chest-location-data.yml");
        this.chestLocationDataConfig = YamlConfiguration.loadConfiguration(chestLocationDataFile);
        loadLocationsFromConfig();
    }

    @EventHandler
    public void onPlayerPlaceChest(BlockPlaceEvent event){
        if (event.getBlockPlaced().getType() == Material.CHEST){
            Player player = event.getPlayer();
            Town town = TownyAPI.getInstance().getTown(player.getLocation());
            if (town != null && town.hasResident(player.getName())){
                Location location = event.getBlockPlaced().getLocation();
                UUID playerId = player.getUniqueId();
                lockChest(location, playerId);
            }
        }
    }
    private void lockChest(Location location, UUID playerId){

    }

    private void loadLocationsFromConfig(){
        for (String playerId : chestLocationDataConfig.getKeys(false)) {
            UUID playerId = UUID.fromString(playerId);
        }
    }
}
