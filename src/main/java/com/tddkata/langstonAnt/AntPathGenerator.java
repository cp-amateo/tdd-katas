package com.tddkata.langstonAnt;

import java.util.Arrays;

import static java.util.Objects.isNull;

public class AntPathGenerator {

    private final Color[][] grid;
    private Point antPosition;

    public AntPathGenerator(int gripSize) {
        if (gripSize % 2 == 0) {
            throw new IllegalArgumentException();
        }

        antPosition = Point.of(gripSize / 2, gripSize / 2);

        grid = new Color[gripSize][gripSize];
        for (Color[] colors : grid) {
            Arrays.fill(colors, Color.WHITE);
        }

    }

    public void simulatePath(final String rules, int steps) {
        checkValidRules(rules);

        for (int step = 0; step < steps; step++) {
            if (rules.contains("R")) {
                grid[antPosition.getX()][antPosition.getY()] = Color.BLACK;
                if (step == 0) antPosition = Point.of(antPosition.getX() - 1, antPosition.getY());
                if (step == 1) antPosition = Point.of(antPosition.getX(), antPosition.getY() + 1);
                if (step == 2) antPosition = Point.of(antPosition.getX() + 1, antPosition.getY());
                if (step == 3) antPosition = Point.of(antPosition.getX(), antPosition.getY() - 1);
            }
        }
    }

    public Point getAntPosition() {
        return antPosition;
    }

    public Color getCell(final int x, final int y) {
        return grid[x][y];
    }

    private void checkValidRules(String rules) {
        if (rules == null || rules.length() < 2) {
            throw new IllegalArgumentException();
        }
    }


    enum Color {
        WHITE,
        BLACK
    }

}
