package com.zaksen.zaksincclocks.clock.digital;

import com.zaksen.zaksincclocks.clock.AbstractClock;
import org.bukkit.Location;
import org.bukkit.Material;

public class DigitalClock extends AbstractClock {

    public DigitalClock(String time, Location location) {
        super(time, location);
    }

    @Override
    public void renderTime() {
        location.getWorld().setBlockData(location, Material.AMETHYST_BLOCK.createBlockData());
    }
}
