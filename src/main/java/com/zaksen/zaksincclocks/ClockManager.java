package com.zaksen.zaksincclocks;

import com.zaksen.zaksincclocks.clock.IClock;
import com.zaksen.zaksincclocks.command.ClocksCommand;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

public class ClockManager {
    private final List<IClock> clockList = new ArrayList<>();
    private TimeZone timeZone;
    private BukkitTask clockTask = null;

    public ClockManager() {
        // Ignore
    }

    public void addClock(IClock clock) {
        clockList.add(clock);
    }

    public void init() {
        timeZone = TimeZone.getTimeZone(ZaksIncClocks.getClocksConfig().timeZone);

        if (clockTask == null) {
            clockTask = new BukkitRunnable() {
                @Override
                public void run() {
                    // Count time
                    LocalTime localTime = LocalTime.now(timeZone.toZoneId());

                    String newTime = ZaksIncClocks.getClocksConfig().timeFormat
                            .replace("{hours}", String.valueOf(localTime.getHour()))
                            .replace("{minutes}", String.valueOf(localTime.getMinute()))
                            .replace("{seconds}", String.valueOf(localTime.getSecond()));

                    // Render time for clocks
                    clockList.forEach(clock -> {
                        clock.updateTime(newTime);
                        clock.renderTime();
                    });
                }
            }.runTaskTimer(ZaksIncClocks.getInstance(), 0, 10);
        }
    }

    public void stop() {
        if (clockTask != null) {
            clockTask.cancel();
            clockTask = null;
        }
    }
}