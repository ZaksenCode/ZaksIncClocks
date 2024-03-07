package com.zaksen.zaksincclocks.command;

import com.zaksen.zaksincclocks.ClockManager;
import com.zaksen.zaksincclocks.ZaksIncClocks;
import com.zaksen.zaksincclocks.clock.digital.DigitalClock;
import com.zaksen.zaksincclocks.clock.text.TextClock;
import com.zaksen.zaksincclocks.util.MessagesUtil;
import com.zaksen.zaksincclocks.util.VariableBuilder;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ClocksCommand implements TabExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (!(commandSender instanceof Player)) {
            MessagesUtil.sendByKey(commandSender, "only-player-command");
        }
        Player sender = (Player) commandSender;

        if (args.length < 1) {
            MessagesUtil.sendByKey(sender, "enter-sub-command");
            return true;
        }

        String subCommand = args[0];

        processSubCommand(sender, subCommand, args);

        return true;
    }

    private void processSubCommand(Player sender, String subCommand, String[] args) {
        switch (subCommand) {
            case "create": {
                if (args.length < 2) {
                    MessagesUtil.sendByKey(sender, "create-need-type-argument");
                    return;
                }
                processCreateCommand(sender, args[1]);
                break;
            }
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
                        new VariableBuilder().newEntry("{type}", type).build()
                );
                return;
            }
        }
        MessagesUtil.sendByKey(sender, "create-success", new VariableBuilder().newEntry("{type}", type).build());
    }

    @Nullable
    @Override
    public List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        switch(args.length) {
            case 1: return Collections.singletonList("create");
            case 2: return Arrays.asList("digital", "text");
        }
        return null;
    }

}
