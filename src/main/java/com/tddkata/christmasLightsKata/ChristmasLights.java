package com.tddkata.christmasLightsKata;

public class ChristmasLights {

    int[][] grid = new int[1000][1000];

    public void turnOff(final Coordinate corner1, final Coordinate corner2) {
    }

    public int getNumberOfLightsOn() {
        int nLightsOn = 0;
        for (int x = 0; x < 1000; x++) {
            for (int y = 0; y < 1000; y++) {
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
