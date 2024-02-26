package com.zaksen.zaksincclocks.clock;

import org.bukkit.Location;
import org.bukkit.entity.TextDisplay;

public class TextClock extends AbstractClock {

    private TextDisplay textDisplayEntity;

    public TextClock(int id, Location location) {
        super(id, location);
    }

    @Override
    public void init() {
        textDisplayEntity = location.getWorld().spawn(location, TextDisplay.class);
    }

    @Override
    public void renderTime() {
        textDisplayEntity.setText(time);
    }
}
