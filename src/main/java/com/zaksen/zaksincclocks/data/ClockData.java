package com.zaksen.zaksincclocks.data;

import java.util.UUID;

public class ClockData {
    private final int id;
    private final UUID uuid;

    public ClockData(int id, UUID uuid) {
        this.id = id;
        this.uuid = uuid;
    }

    public ClockData(int id, String uuid) {
        this(id, UUID.fromString(uuid));
    }

    public int getId() {
        return id;
    }

    public UUID getUuid() {
        return uuid;
    }
}