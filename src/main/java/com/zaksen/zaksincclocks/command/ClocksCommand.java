package com.zaksen.zaksincclocks.command;

import com.zaksen.zaksincclocks.ZaksIncClocks;
import com.zaksen.zaksincclocks.clock.digital.DigitalClock;
import com.zaksen.zaksincclocks.clock.text.TextClock;
import com.zaksen.zaksincclocks.util.MessagesUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ClocksCommand implements TabExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (!(commandSender instanceof Player sender)) {
            MessagesUtil.sendByKey(commandSender, "only-player-command");
            return true;
        }

        if (args.length < 1) {
            MessagesUtil.sendByKey(sender, "enter-sub-command");
            return true;
        }

        String subCommand = args[0];

        processSubCommand(sender, subCommand, args);

        return true;
    }

    private void processSubCommand(Player sender, String subCommand, String[] args) {
        if (subCommand.equals("create")) {
            if (args.length < 2) {
                MessagesUtil.sendByKey(sender, "create-need-type-argument");
                return;
            }
            processCreateCommand(sender, args[1]);
        }
    }

    private void processCreateCommand(Player sender, String type) {
        switch (type) {
            case "text": {
                ZaksIncClocks.getClockManager().addClock(new TextClock("00:00:00", sender.getLocation()));
                break;
            }
            case "digital": {
                ZaksIncClocks.getClockManager().addClock(new DigitalClock("00:00:00", sender.getLocation()));
                break;
            }
            default: {
                MessagesUtil.sendByKey(
                        sender,
                        "create-no-type-error",
                        Map.of("{type}", type)
                );
                return;
            }
        }
        MessagesUtil.sendByKey(sender, "create-success", Map.of("{type}", type));
    }

    @Nullable
    @Override
    public List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        return switch (args.length) {
            case 1 -> List.of("create");
            case 2 -> List.of("digital", "text");
            default -> null;
        };
    }

}
