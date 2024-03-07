package com.zaksen.zaksincclocks;

import com.zaksen.zaksincclocks.command.ClocksCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class ZaksIncClocks extends JavaPlugin {

    private static ZaksIncClocks instance;
    private static ClocksConfig mainConfig;
    private static final ClockManager clockManager = new ClockManager();

    public static ZaksIncClocks getInstance() {
        return instance;
    }

    public static ClocksConfig getClocksConfig() {
        return mainConfig;
    }

    public static ClockManager getClockManager() {
        return clockManager;
    }

    @Override
    public void onEnable() {
        // Load default config
        saveDefaultConfig();

        // Setup
        instance = this;
        mainConfig = new ClocksConfig(instance.getConfig());

        clockManager.init();

        // Register command
        getCommand("clocks").setExecutor(new ClocksCommand());
        getCommand("clocks").setTabCompleter(new ClocksCommand());

    }

    @Override
    public void onDisable() {
        clockManager.stop();
    }
}
