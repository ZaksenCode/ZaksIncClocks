package com.zaksen.zaksincclocks.blockfont;

import org.joml.Vector3i;

import javax.annotation.Nullable;

// TODO - remade it's normal

// WARNING - VERY HARDCODED
//
//
//
//
// I am seriously

public enum EightBlockFont {
    ZERO('0', new Vector3i[] {
            // First column
            new Vector3i(1, 1, 0),
            new Vector3i(1, 2, 0),
            new Vector3i(1, 3, 0),
            new Vector3i(1, 4, 0),
            new Vector3i(1, 5, 0),
            new Vector3i(1, 6, 0),
            new Vector3i(1, 7, 0),
            new Vector3i(1, 8, 0),
            // Second column
            new Vector3i(2, 0, 0),
            new Vector3i(2, 1, 0),
            new Vector3i(2, 2, 0),
            new Vector3i(2, 3, 0),
            new Vector3i(2, 4, 0),
            new Vector3i(2, 5, 0),
            new Vector3i(2, 6, 0),
            new Vector3i(2, 7, 0),
            new Vector3i(2, 8, 0),
            new Vector3i(2, 9, 0),
            // Third column
            new Vector3i(3, 0, 0),
            new Vector3i(3, 1, 0),
            new Vector3i(3, 8, 0),
            new Vector3i(3, 9, 0),
            // Fourth column
            new Vector3i(4, 0, 0),
            new Vector3i(4, 1, 0),
            new Vector3i(4, 8, 0),
            new Vector3i(4, 9, 0),
            // Fifth column
            new Vector3i(5, 0, 0),
            new Vector3i(5, 1, 0),
            new Vector3i(5, 2, 0),
            new Vector3i(5, 3, 0),
            new Vector3i(5, 4, 0),
            new Vector3i(5, 5, 0),
            new Vector3i(5, 6, 0),
            new Vector3i(5, 7, 0),
            new Vector3i(5, 8, 0),
            new Vector3i(5, 9, 0),
            // Sixth column
            new Vector3i(6, 1, 0),
            new Vector3i(6, 2, 0),
            new Vector3i(6, 3, 0),
            new Vector3i(6, 4, 0),
            new Vector3i(6, 5, 0),
            new Vector3i(6, 6, 0),
            new Vector3i(6, 7, 0),
            new Vector3i(6, 8, 0),
    }),
    ONE('1', new Vector3i[] {
            // First column
            new Vector3i(2, 6, 0),
            new Vector3i(2, 7, 0),
            // Second column
            new Vector3i(3, 6, 0),
            new Vector3i(3, 7, 0),
            new Vector3i(3, 8, 0),
            // Third column
            new Vector3i(4, 0, 0),
            new Vector3i(4, 1, 0),
            new Vector3i(4, 2, 0),
            new Vector3i(4, 3, 0),
            new Vector3i(4, 4, 0),
            new Vector3i(4, 5, 0),
            new Vector3i(4, 6, 0),
            new Vector3i(4, 7, 0),
            new Vector3i(4, 8, 0),
            new Vector3i(4, 9, 0),
            // Fourth column
            new Vector3i(5, 0, 0),
            new Vector3i(4, 1, 0),
            new Vector3i(5, 2, 0),
            new Vector3i(5, 3, 0),
            new Vector3i(5, 4, 0),
            new Vector3i(5, 5, 0),
            new Vector3i(5, 6, 0),
            new Vector3i(5, 7, 0),
            new Vector3i(5, 8, 0),
            new Vector3i(5, 9, 0),
    }),
    TWO('2', new Vector3i[] {
            // First column
            new Vector3i(1, 0, 0),
            new Vector3i(1, 1, 0),
            new Vector3i(1, 2, 0),
            new Vector3i(1, 7, 0),
            new Vector3i(1, 8, 0),
            // Second column
            new Vector3i(1, 0, 0),
            new Vector3i(1, 1, 0),
            new Vector3i(1, 2, 0),
            new Vector3i(1, 3, 0),
            new Vector3i(1, 7, 0),
            new Vector3i(1, 8, 0),
            new Vector3i(1, 9, 0),
            // Third column
            new Vector3i(1, 0, 0),
            new Vector3i(1, 1, 0),
            new Vector3i(1, 2, 0),
            new Vector3i(1, 3, 0),
            new Vector3i(1, 4, 0),
            new Vector3i(1, 8, 0),
            new Vector3i(1, 9, 0),
            // Fourth column
            new Vector3i(1, 0, 0),
            new Vector3i(1, 1, 0),
            new Vector3i(1, 3, 0),
            new Vector3i(1, 4, 0),
            new Vector3i(1, 5, 0),
            new Vector3i(1, 8, 0),
            new Vector3i(1, 9, 0),
            // Fifth column
            new Vector3i(1, 0, 0),
            new Vector3i(1, 1, 0),
            new Vector3i(1, 4, 0),
            new Vector3i(1, 5, 0),
            new Vector3i(1, 6, 0),
            new Vector3i(1, 7, 0),
            new Vector3i(1, 8, 0),
            new Vector3i(1, 9, 0),
            // Sixth column
            new Vector3i(1, 0, 0),
            new Vector3i(1, 1, 0),
            new Vector3i(1, 5, 0),
            new Vector3i(1, 6, 0),
            new Vector3i(1, 7, 0),
            new Vector3i(1, 8, 0),
    }),
    THREE('3', new Vector3i[] {

    }),
    FOUR('4', new Vector3i[] {

    }),
    FIVE('5', new Vector3i[] {

    }),
    SIX('6', new Vector3i[] {

    }),
    SEVEN('7', new Vector3i[] {

    }),
    EIGHT('8', new Vector3i[] {

    }),
    NINE('9', new Vector3i[] {

    }),
    COLON(':', new Vector3i[] {

    });

    private final char chr;
    private final Vector3i[] locations;

    EightBlockFont(char chr, Vector3i[] locations) {
        this.chr = chr;
        this.locations = locations;
    }

    @Nullable
    public static EightBlockFont getBy(char chr) {
        for (EightBlockFont value : values()) {
            if (value.chr == chr) {
                return value;
            }
        }
        return null;
    }

    public Vector3i[] getLocations() {
        return locations;
    }
}
