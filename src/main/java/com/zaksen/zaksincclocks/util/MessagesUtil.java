package com.zaksen.zaksincclocks.util;

import com.zaksen.zaksincclocks.ZaksIncClocks;
import org.bukkit.command.CommandSender;

import java.util.Map;

public class MessagesUtil {

    public static void send(CommandSender sender, String message, Map<String, String> variables) {
        for (Map.Entry<String, String> var : variables.entrySet()) {
            message = message.replace(var.getKey(), var.getValue());
        }
        send(sender, message);
    }

    public static void send(CommandSender sender, String message) {
        sender.sendMessage(message);
    }

    public static void sendByKey(CommandSender sender, String key, Map<String, String> variables) {
        String message = ZaksIncClocks.getClocksConfig().messages.get(key);
        for (Map.Entry<String, String> var : variables.entrySet()) {
            message = message.replace(var.getKey(), var.getValue());
        }
        send(sender, message);
    }

    public static void sendByKey(CommandSender sender, String key) {
        send(sender, ZaksIncClocks.getClocksConfig().messages.get(key));
    }
}