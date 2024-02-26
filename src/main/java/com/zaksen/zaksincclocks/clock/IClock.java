package com.zaksen.zaksincclocks.clock;


import org.bukkit.Location;

public interface IClock {

    void init();

    Location getLocation();

    void updateTime(String time);

    void renderTime();

    int getId();

    default void render() {
        renderTime();
    }

}