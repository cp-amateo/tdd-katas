package com.tddkata.christmasLightsKata;

public class ChristmasLights {

    public static final int ROWS = 1000;
    public static final int COLUMNS = 1000;
    int[][] grid = new int[ROWS][COLUMNS];

    public void turnOff(final Coordinate corner1, final Coordinate corner2) {
        for (int x = corner1.getX(); x <= corner2.getX(); x++) {
            for (int y = corner1.getY(); y <= corner2.getY(); y++) {
                grid[x][y] = 0;
            }
        }
    }

    public int getNumberOfLightsOn() {
        int nLightsOn = 0;
        for (int x = 0; x < ROWS; x++) {
            for (int y = 0; y < COLUMNS; y++) {
                nLightsOn += grid[x][y];
            }
        }
        return nLightsOn;
    }

    public void turnOn(final Coordinate corner1, final Coordinate corner2) {
        for (int x = corner1.getX(); x <= corner2.getX(); x++) {
            for (int y = corner1.getY(); y <= corner2.getY(); y++) {
                grid[x][y] = 1;
            }
        }
    }
}
