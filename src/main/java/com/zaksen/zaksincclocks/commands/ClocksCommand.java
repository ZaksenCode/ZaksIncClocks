package com.zaksen.zaksincclocks.commands;

import com.zaksen.zaksincclocks.ZaksIncClocks;
import com.zaksen.zaksincclocks.clock.ClockManager;
import com.zaksen.zaksincclocks.clock.DigitalClock;
import com.zaksen.zaksincclocks.clock.TextClock;
import com.zaksen.zaksincclocks.utils.MessagesUtil;
import com.zaksen.zaksincclocks.utils.VariablesBuilder;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ClocksCommand implements TabExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if(!(commandSender instanceof Player)) {
            commandSender.sendMessage(ZaksIncClocks.getClocksConfig().messages.get("only-player-command"));
            return true;
        }
        Player sender = (Player) commandSender;

        if(args.length < 1) {
            commandSender.sendMessage(ZaksIncClocks.getClocksConfig().messages.get("enter-sub-command"));
            return true;
        }

        String subCommand = args[0];

        switch (subCommand) {
            case "create": {
                if(args.length < 2) {
                    MessagesUtil.sendByKey(sender, "create-need-type-argument");
                    return true;
                }

                String type = args[1];
                int id = ClockManager.getInstance().getClocksCount();

                switch (type) {
                    case "digital": {
                        DigitalClock clock = new DigitalClock(id, sender.getLocation());
                        ClockManager.getInstance().addClock(id, clock);
                        break;
                    }
                    case "analog": {

                        break;
                    }
                    case "text": {
                        TextClock clock = new TextClock(id, sender.getLocation());
                        ClockManager.getInstance().addClock(id, clock);
                        break;
                    }
                    default: {
                        MessagesUtil.sendByKey(sender, "create-no-type-error",
                                new VariablesBuilder().newEntry("{type}", type).build());
                        return true;
                    }
                }
                MessagesUtil.sendByKey(sender, "create-success",
                        new VariablesBuilder().newEntry("{id}", String.valueOf(id)).build());
                return true;
            }
        }

        return false;
    }

    @Nullable
    @Override
    public List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        return null;
    }

}
