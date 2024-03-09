package com.zaksen.zaksincclocks.clock;

import org.bukkit.Location;

public abstract class AbstractClock implements Clock {

    protected String time;
    protected Location location;

    protected AbstractClock(String time, Location location) {
        this.time = time;
        this.location = location;
    }

    @Override
    public void updateTime(String time) {
        this.time = time;
    }
}
