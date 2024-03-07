package com.zaksen.zaksincclocks.clock.digital;

import com.zaksen.zaksincclocks.ZaksIncClocks;
import com.zaksen.zaksincclocks.clock.AbstractClock;
import org.bukkit.Location;

public class DigitalClock extends AbstractClock {

    public DigitalClock(String time, Location location) {
        super(time, location);
    }

    @Override
    public void renderTime() {
        // TODO - Convert string into blocks
        int offset = 0;

        for (char c : time.toCharArray()) {
            location.getWorld().setBlockData(new Location(location.getWorld(), location.getBlockX() + offset, location.getBlockY(), location.getBlockZ()), ZaksIncClocks.getClocksConfig().fontBlock);
            offset++;
        }
    }
}
