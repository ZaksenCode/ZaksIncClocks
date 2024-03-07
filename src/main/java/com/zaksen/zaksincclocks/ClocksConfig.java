package com.zaksen.zaksincclocks;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.data.BlockData;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.HashMap;
import java.util.Map;

public class ClocksConfig {
    public final String timeZone;
    public final String timeFormat;
    public final Map<String, String> messages = new HashMap<>();
    public final int fontSize;
    public final BlockData fontBlock;

    public ClocksConfig(FileConfiguration config) {
        timeZone = config.getString("time-zone");
        timeFormat = config.getString("time-format");

        newMessage("only-player-command", config);
        newMessage("enter-sub-command", config);
        newMessage("create-need-type-argument", config);
        newMessage("create-no-type-error", config);
        newMessage("create-success", config);

        fontSize = config.getInt("font-size");
        fontBlock = Material.valueOf(config.getString("font-block")).createBlockData();
    }

    private void newMessage(String name, FileConfiguration from) {
        messages.put(name, ChatColor.translateAlternateColorCodes('&', from.getString(String.format("messages.%s", name))));
    }
}