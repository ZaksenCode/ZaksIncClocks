package com.zaksen.zaksincclocks.clock.text;

import com.zaksen.zaksincclocks.ZaksIncClocks;
import com.zaksen.zaksincclocks.clock.AbstractClock;
import org.bukkit.Location;
import org.bukkit.entity.TextDisplay;

public class TextClock extends AbstractClock {

    private TextDisplay entity;

    public TextClock(String time, Location location) {
        super(time, location);
        if (location.getWorld() == null) {
            ZaksIncClocks.getInstance().getLogger().info("Unable to create text clock: world wasn't found!");
            return;
        }
        entity = location.getWorld().spawn(location, TextDisplay.class);
    }

    @Override
    public void renderTime() {
        entity.setText(time);
    }
}
