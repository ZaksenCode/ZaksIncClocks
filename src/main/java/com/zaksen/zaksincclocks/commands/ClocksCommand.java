package com.zaksen.zaksincclocks.commands;

import com.zaksen.zaksincclocks.ZaksIncClocks;
import com.zaksen.zaksincclocks.clock.AbstractClock;
import com.zaksen.zaksincclocks.clock.ClockManager;
import com.zaksen.zaksincclocks.clock.ClocksEnum;
import com.zaksen.zaksincclocks.utils.MessagesUtil;
import com.zaksen.zaksincclocks.utils.VariablesBuilder;
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
        if(!(commandSender instanceof Player)) {
            MessagesUtil.sendByKey(commandSender, "only-player-command");
            return true;
        }

        Player sender = (Player) commandSender;

        if(args.length < 1) {
            MessagesUtil.sendByKey(sender, "enter-sub-command");
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

                ClocksEnum clockEn = ClocksEnum.findByString(type.toLowerCase());

                if(clockEn == null) {
                    MessagesUtil.sendByKey(sender, "create-no-type-error",
                            new VariablesBuilder()
                                    .newEntry("{type}", type).build());
                    return true;
                }

                clockEn.create(id, sender.getLocation());

                MessagesUtil.sendByKey(sender, "create-success",
                        new VariablesBuilder()
                                .newEntry("{type}", type)
                                .newEntry("{id}", String.valueOf(id))
                                .build());
                return true;
            }
            case "remove": {
                if(args.length > 2) {
                    MessagesUtil.sendByKey(sender, "remove-need-type-argument");
                    return true;
                }
            }
            case "list": {
                int page = 0;

                if(args.length > 2) {
                    page = Integer.parseInt(args[1]) - 1;
                }

                MessagesUtil.sendByKey(sender, "list-show", new VariablesBuilder()
                        .newEntry("{page}", String.valueOf(page + 1)).build());

                int pageStartIdx = page * ZaksIncClocks.getClocksConfig().clocksListPerPage;
                int pageEndIdx = pageStartIdx + ZaksIncClocks.getClocksConfig().clocksListPerPage;

                for(int i = pageStartIdx; i < pageEndIdx; i++) {
                    if(ClockManager.getInstance().getClock(i) != null) {
                        AbstractClock clockPrint = ClockManager.getInstance().getClock(i);
                        String location = String.format("X:%s, Y:%s, Z:%s",
                                clockPrint.getLocation().getX(),
                                clockPrint.getLocation().getY(),
                                clockPrint.getLocation().getZ());
                        MessagesUtil.send(sender, ZaksIncClocks.getClocksConfig().clocksListFormat, new VariablesBuilder()
                                .newEntry("{id}", String.valueOf(clockPrint.getId()))
                                .newEntry("{type}", clockPrint.getType())
                                .newEntry("{location}", location)
                                .build());
                    }
                }
                return true;
            }
        }

        return false;
    }

    @Nullable
    @Override
    public List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (args.length == 1) {
            return Arrays.asList("create", "remove", "list");
        }
        if (args.length == 2) {
            String subCommand = args[0];
            switch (subCommand) {
                case "create": {
                    return Arrays.asList("text", "digital", "analog");
                }
                case "remove": {
                    return Collections.singletonList("id");
                }
                case "list": {
                    return Collections.singletonList("page");
                }
            }
        }
        return null;
    }

}
