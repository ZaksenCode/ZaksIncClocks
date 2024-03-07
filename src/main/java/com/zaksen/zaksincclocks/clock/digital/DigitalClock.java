package com.zaksen.zaksincclocks.clock.digital;

import com.zaksen.zaksincclocks.ZaksIncClocks;
import com.zaksen.zaksincclocks.clock.AbstractClock;
import org.bukkit.Location;
import org.bukkit.Material;

public class DigitalClock extends AbstractClock {

    public DigitalClock(String time, Location location) {
        super(time, location);
    }

    @Override
    public void renderTime() {
        // TODO - Convert string into blocks
        location.getWorld().setBlockData(location, ZaksIncClocks.getClocksConfig().fontBlock);
    }
}
