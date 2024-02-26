package com.zaksen.zaksincclocks;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.HashMap;
import java.util.Map;

public class ClocksConfig {
    public final String timeZone;
    public final String timeFormat;
    public final Map<String, String> messages = new HashMap<>();
    public final String clocksListFormat;
    public final int clocksListPerPage;
    public final String fontName;
    public final int fontSize;

    public ClocksConfig(FileConfiguration config) {
        timeZone = config.getString("time-zone");
        timeFormat = config.getString("time-format");

        newMessage("only-player-command", config);
        newMessage("enter-sub-command", config);
        newMessage("create-need-type-argument", config);
        newMessage("create-no-type-error", config);
        newMessage("create-success", config);

        clocksListFormat = config.getString("clocks-list-format");
        clocksListPerPage = config.getInt("clocks-list-per-page");

        fontName = config.getString("font-name");
        fontSize = config.getInt("font-size");
    }

    private void newMessage(String name, FileConfiguration from) {
        messages.put(name, ChatColor.translateAlternateColorCodes('&', from.getString(name)));
    }
}