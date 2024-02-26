package com.zaksen.zaksincclocks.clock;

import com.zaksen.zaksincclocks.ZaksIncClocks;
import org.bukkit.Location;

public class DigitalClock extends AbstractClock {

    public DigitalClock(int id, Location location) {
        super(id, location);
    }

    @Override
    public void init() {

    }

    @Override
    public void renderTime() {
        location.getWorld().setBlockData(location, ZaksIncClocks.getClocksConfig().fontBlock);
    }

    @Override
    public String getType() {
        return "digital";
    }
}
