package com.zaksen.zaksincclocks.clock;

import com.zaksen.zaksincclocks.ZaksIncClocks;
import org.bukkit.scheduler.BukkitRunnable;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

public class ClockManager {
    private static final ClockManager instance = new ClockManager();
    private Map<Integer, AbstractClock> clockMap = new HashMap<>();
    private TimeZone timeZone;
    private BukkitRunnable cycleTask = null;
    private String lastTime;

    public static ClockManager getInstance() {
        return instance;
    }

    private ClockManager() {
    }

    public void init() {
        if (cycleTask != null) {
            return;
        }

        timeZone = TimeZone.getTimeZone(ZaksIncClocks.getClocksConfig().timeZone);

        cycleTask = new BukkitRunnable() {
            @Override
            public void run() {
                updateClocks();
                renderClocks();
            }
        };
        cycleTask.runTaskTimer(ZaksIncClocks.getInstance(), 0, 10);
    }

    public void stop() {
        if (cycleTask == null) {
            return;
        }

        cycleTask.cancel();
        cycleTask = null;
    }

    public int getClocksCount() {
        return clockMap.size();
    }

    public void addClock(int id, AbstractClock clock) {
        clockMap.put(id, clock);
    }

    public AbstractClock getClock(int id) {
        return clockMap.get(id);
    }

    public void removeClock(int id) {
        clockMap.remove(id);
    }

    private void updateClocks() {
        LocalTime localTime = LocalTime.now(timeZone.toZoneId());

        lastTime = ZaksIncClocks.getClocksConfig().timeFormat
                .replace("{hours}", String.valueOf(localTime.getHour()))
                .replace("{minutes}", String.valueOf(localTime.getMinute()))
                .replace("{seconds}", String.valueOf(localTime.getSecond()));

        clockMap.forEach(((integer, clock) -> clock.updateTime(lastTime)));
    }

    private void renderClocks() {
        clockMap.forEach(((integer, clock) -> clock.render()));
    }
}
