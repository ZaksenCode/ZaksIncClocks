package com.zaksen.zaksincclocks.clock;

import org.bukkit.Location;

import java.util.function.BiConsumer;

public enum ClocksEnum {

    DIGITAL("digital", (id, location) -> {
        DigitalClock clock = new DigitalClock(id, location);
        ClockManager.getInstance().addClock(id, clock);
    }),
    ANALOG("analog", (id, location) -> {
        AnalogClock clock = new AnalogClock(id, location);
        ClockManager.getInstance().addClock(id, clock);
    }),
    TEXT("text", (id, location) -> {
        TextClock clock = new TextClock(id, location);
        ClockManager.getInstance().addClock(id, clock);
    });


    private final String type;
    private final BiConsumer<Integer, Location> consumer;

    ClocksEnum(String type, BiConsumer<Integer, Location> consumer) {
        this.type = type;
        this.consumer = consumer;
    }

    public static ClocksEnum findByString(String findType) {
        for(ClocksEnum enumType : values()) {
            if (enumType.type.equals(findType)) {
                return enumType;
            }
        }
        return null;
    }

    public void create(int id, Location location) {
        consumer.accept(id, location);
    }
}
