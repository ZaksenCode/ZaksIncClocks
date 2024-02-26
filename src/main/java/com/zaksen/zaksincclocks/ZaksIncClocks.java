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
    private static ZaksIncClocks instance;
    private static ClocksConfig mainConfig;

    public static ZaksIncClocks getInstance() {
        return instance;
    }

    public static ClocksConfig getClocksConfig() {
        return mainConfig;
    }

    @Override
    public void onEnable() {
        // Load default config
        saveDefaultConfig();

        // Setup
        instance = this;
        mainConfig = new ClocksConfig(instance.getConfig());
        DatabaseManager.getInstance().init();
        ClockManager.getInstance().init();

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
