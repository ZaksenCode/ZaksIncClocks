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
    public final int charSizeX;
    public final int charSizeY;
    public final int charGap;

    public ClocksConfig(FileConfiguration config) {
        timeZone = config.getString("time-zone");
        timeFormat = config.getString("time-format");

        // TODO - Auto load all strings from messages
        // Maybe work?
//        for (String key : config.getConfigurationSection("messages").getKeys(false)) {
//            newMessage(key, config);
//        }

        newMessage("only-player-command", config);
        newMessage("enter-sub-command", config);
        newMessage("create-need-type-argument", config);
        newMessage("create-no-type-error", config);
        newMessage("create-success", config);

        fontSize = config.getInt("font-size");
        fontBlock = Material.valueOf(config.getString("font-block")).createBlockData();

        charSizeX = config.getInt("char-size-x");
        charSizeY = config.getInt("char-size-y");
        charGap = config.getInt("char-gap");
    }

    private void newMessage(String name, FileConfiguration from) {
        messages.put(name, ChatColor.translateAlternateColorCodes('&', from.getString(String.format("messages.%s", name))));
    }
}