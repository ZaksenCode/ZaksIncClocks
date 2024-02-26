package com.zaksen.zaksincclocks.data;

import java.util.HashMap;
import java.util.Map;

public class FontData {
    private final Map<Character, LocationArray> charsArray = new HashMap<>();

    public void addCharWithLocation(char chr, LocationArray worldChar) {
        charsArray.put(chr, worldChar);
    }

    public LocationArray getCharAsLocation(char chr) {
        return charsArray.get(chr);
    }
}