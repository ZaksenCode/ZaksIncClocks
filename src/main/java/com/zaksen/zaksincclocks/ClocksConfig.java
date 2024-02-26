package com.zaksen.zaksincclocks;

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

        messages.put("only-player-command", config.getString("only-player-command"));

        clocksListFormat = config.getString("clocks-list-format");
        clocksListPerPage = config.getInt("clocks-list-per-page");

        fontName = config.getString("font-name");
        fontSize = config.getInt("font-size");
    }
}