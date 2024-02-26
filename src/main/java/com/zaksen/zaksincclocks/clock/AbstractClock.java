package com.zaksen.zaksincclocks.clock;

import org.bukkit.Location;

public abstract class AbstractClock implements IClock {

    protected final int id;
    protected final Location location;
    protected String time = "";

    protected AbstractClock(int id, Location location) {
        this.id = id;
        this.location = location;
        init();
    }

    @Override
    public Location getLocation() {
        return location;
    }

    @Override
    public void updateTime(String time) {
        this.time = time;
    }

    @Override
    public int getId() {
        return id;
    }

}