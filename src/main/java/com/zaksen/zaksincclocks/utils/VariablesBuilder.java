package com.zaksen.zaksincclocks.utils;

import java.util.HashMap;
import java.util.Map;

public class VariablesBuilder {
    private Map<String, String> variablesMap = new HashMap<>();

    public VariablesBuilder newEntry(String from, String to) {
        variablesMap.put(from, to);
        return this;
    }

    public Map<String, String> build() {
        return variablesMap;
    }
}