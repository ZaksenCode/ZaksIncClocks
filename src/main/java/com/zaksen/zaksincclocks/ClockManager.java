package com.zaksen.zaksincclocks;

import com.zaksen.zaksincclocks.clock.Clock;

import java.time.LocalTime;
import java.util.*;

public class ClockManager {
    public static final Timer timer = new Timer();
    private final List<Clock> clockList = new ArrayList<>();
    private TimeZone timeZone;
    private TimerTask clockTask = null;

    public ClockManager() {
        // Ignore
    }

    public void addClock(Clock clock) {
        clockList.add(clock);
    }

    public void init() {
        timeZone = TimeZone.getTimeZone(ZaksIncClocks.getClocksConfig().timeZone);

        if (clockTask == null) {

            timer.scheduleAtFixedRate(clockTask = new TimerTask() {
                @Override
                public void run() {
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
            }, 0, 500);
        }
    }

    public void stop() {
        if (clockTask != null) {
            clockTask.cancel();
            clockTask = null;
        }
    }
}