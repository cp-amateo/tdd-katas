package com.tddkata.christmasLightsKata;

import static com.tddkata.christmasLightsKata.LIGHT_ACTION.ON;

public class ChristmasLights {

    public static final int ROWS = 1000;
    public static final int COLUMNS = 1000;

    int[][] grid = new int[ROWS][COLUMNS];

    public void turnOn(final Coordinate corner1, final Coordinate corner2) {
        changeLight(ON, corner1, corner2);
    }

    public void turnOff(final Coordinate corner1, final Coordinate corner2) {
        changeLight(LIGHT_ACTION.OFF, corner1, corner2);
    }

    public void toggle(final Coordinate corner1, final Coordinate corner2) {
        changeLight(LIGHT_ACTION.TOGGLE, corner1, corner2);
    }

    public int getBrightness() {
        int nLightsOn = 0;
        for (int x = 0; x < ROWS; x++) {
            for (int y = 0; y < COLUMNS; y++) {
                nLightsOn += grid[x][y];
            }
        }

        return nLightsOn;
    }

    private void changeLight(LIGHT_ACTION lightAction, Coordinate corner1, Coordinate corner2) {
        for (int x = corner1.getX(); x <= corner2.getX(); x++) {
            for (int y = corner1.getY(); y <= corner2.getY(); y++) {
                grid[x][y] = calculateLightValueBy(lightAction, grid[x][y]);
            }
        }
    }

    private int calculateLightValueBy(final LIGHT_ACTION lightAction, final int value) {
        return switch (lightAction) {
            case ON -> value + 1;
            case OFF -> value <= 1
                    ? 0
                    : value - 1;
            case TOGGLE -> value +2;
            default -> throw new IllegalStateException("Unexpected value: " + lightAction);
        };
    }
}
