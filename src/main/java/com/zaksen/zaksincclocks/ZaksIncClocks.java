package com.zaksen.zaksincclocks;

import com.zaksen.zaksincclocks.clock.ClockManager;
import com.zaksen.zaksincclocks.commands.ClocksCommand;
import com.zaksen.zaksincclocks.database.DatabaseManager;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class ZaksIncClocks extends JavaPlugin {

    public static final Logger LOGGER = LoggerFactory.getLogger(ZaksIncClocks.class);

    static private ZaksIncClocks instance;

    public static ZaksIncClocks getInstance() {
        return instance;
    }

    public static ClocksConfig getClocksConfig() {
        return new ClocksConfig(instance.getConfig());
    }

    @Override
    public void onEnable() {
        // Setup
        instance = this;
        DatabaseManager.getInstance().init();
        ClockManager.getInstance().init();
        // Load default config
        saveDefaultConfig();
        // Register command
        getCommand("clocks").setExecutor(new ClocksCommand());
        getCommand("clocks").setTabCompleter(new ClocksCommand());

    }

    @Override
    public void onDisable() {


        // End
        ClockManager.getInstance().stop();
        DatabaseManager.getInstance().stop();
    }
}
