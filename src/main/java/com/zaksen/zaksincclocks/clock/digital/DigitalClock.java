package com.zaksen.zaksincclocks.clock.digital;

import com.zaksen.zaksincclocks.ZaksIncClocks;
import com.zaksen.zaksincclocks.clock.AbstractClock;
import com.zaksen.zaksincclocks.util.TextConverter;
import org.bukkit.Location;

public class DigitalClock extends AbstractClock {

    public DigitalClock(String time, Location location) {
        super(time, location);
    }

    @Override
    public void renderTime() {
        TextConverter.buildText(time, location);
    }
}
