package com.zaksen.zaksincclocks.clock;

import com.zaksen.zaksincclocks.ClocksConfig;
import com.zaksen.zaksincclocks.ZaksIncClocks;
import org.bukkit.Location;
import org.bukkit.Material;

public class AnalogClock extends AbstractClock {

    public AnalogClock(int id, Location location) {
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
        return "analog";
    }
}
