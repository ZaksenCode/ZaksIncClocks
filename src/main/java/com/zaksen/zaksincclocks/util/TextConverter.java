package com.zaksen.zaksincclocks.util;

import com.zaksen.zaksincclocks.ZaksIncClocks;
import com.zaksen.zaksincclocks.blockfont.EightBlockFont;
import org.bukkit.Location;
import org.bukkit.Material;
import org.joml.Vector3i;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class TextConverter {

    @Nullable
    public static Vector3i[] charToLocations(char chr) {
        EightBlockFont symbol = EightBlockFont.getBy(chr);

        if (symbol == null) {
            ZaksIncClocks.getInstance().getLogger().info(String.format("Unable found char for: %s", chr));
            return null;
        }

        return symbol.getLocations();
    }

    public static List<Vector3i[]> stringToLocations(String string) {
        List<Vector3i[]> result = new ArrayList<>();

        for(char chr : string.toCharArray()) {
            Vector3i[] charLocations = charToLocations(chr);
            if (charLocations != null) {
                result.add(charLocations);
            }
        }

        return result;
    }

    public static void buildText(String text, Location startPoint) {
        int offset = 0;

        List<Vector3i[]> locations = stringToLocations(text);

        if (locations.isEmpty()) {
            return;
        }

        for(Vector3i[] charLocations : locations) {
            // Clean up old
            for(int x = 0; x < ZaksIncClocks.getClocksConfig().charSizeX; x++) {
                for(int y = 0; y < ZaksIncClocks.getClocksConfig().charSizeY; y++) {
                    Location location = new Location(
                            startPoint.getWorld(),
                            startPoint.getBlockX() + offset + x,
                            startPoint.getBlockY() + y,
                            startPoint.getBlockZ()
                    );

                    startPoint.getWorld().setBlockData(location, Material.AIR.createBlockData());
                }
            }

            // Draw new
            for(Vector3i localPos : charLocations) {
                Location location = new Location(
                        startPoint.getWorld(),
                        startPoint.getBlockX() + offset + localPos.x,
                        startPoint.getBlockY() + localPos.y,
                        startPoint.getBlockZ() + localPos.z
                );

                startPoint.getWorld().setBlockData(location, ZaksIncClocks.getClocksConfig().fontBlock);
            }

            offset += ZaksIncClocks.getClocksConfig().charSizeX + ZaksIncClocks.getClocksConfig().charGap;
        }
    }
}
