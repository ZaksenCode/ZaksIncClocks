package com.zaksen.zaksincclocks.util;

import java.util.HashMap;
import java.util.Map;

public class VariableBuilder {
    private Map<String, String> variablesMap = new HashMap<>();

    public VariableBuilder newEntry(String from, String to) {
        variablesMap.put(from, to);
        return this;
    }

    public Map<String, String> build() {
        return variablesMap;
    }
}