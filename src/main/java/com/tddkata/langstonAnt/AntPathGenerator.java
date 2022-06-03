package com.tddkata.langstonAnt;

import java.util.Arrays;

import static com.tddkata.langstonAnt.AntPathGenerator.Direction.DOWN;
import static com.tddkata.langstonAnt.AntPathGenerator.Direction.LEFT;
import static com.tddkata.langstonAnt.AntPathGenerator.Direction.RIGHT;
import static com.tddkata.langstonAnt.AntPathGenerator.Direction.UP;
import static java.util.Objects.isNull;

public class AntPathGenerator {

    private final Color[][] grid;
    private Point antPosition;
    private int antDirection = 0;

    private final Direction[] directions = new Direction[]{LEFT, UP, RIGHT, DOWN};

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
            if (Color.WHITE == getCell()) {
                if (rules.contains("R")) {
                    switchColor();
                    changeDirection(Movement.RIGHT);
                    moveForward();
                }
            } else if (Color.BLACK == getCell()) {
                if (rules.contains("L")) {
                    switchColor();
                    changeDirection(Movement.LEFT);
                    moveForward();
                }
            }
        }
    }

    private Color getCell() {
        return grid[antPosition.getX()][antPosition.getY()];
    }

    private void switchColor() {
        if (Color.WHITE == getCell()) {
            grid[antPosition.getX()][antPosition.getY()] = Color.BLACK;
        } else if (Color.BLACK == getCell()) {
            grid[antPosition.getX()][antPosition.getY()] = Color.WHITE;
        }
    }

    public Point getAntPosition() {
        return antPosition;
    }

    public Color getCell(final int x, final int y) {
        return grid[x][y];
    }

    private void changeDirection(final Movement movement) {
        if (Movement.RIGHT == movement) {
            antDirection = (antDirection + 1) % directions.length;
        }
        if (Movement.LEFT == movement) {
            antDirection = antDirection == 0
                    ? directions.length - 1
                    : antDirection - 1;
        }
    }

    private void moveForward() {
        switch (directions[antDirection]) {
            case UP -> antPosition = Point.of(antPosition.getX() - 1, antPosition.getY());
            case RIGHT -> antPosition = Point.of(antPosition.getX(), antPosition.getY() + 1);
            case DOWN -> antPosition = Point.of(antPosition.getX() + 1, antPosition.getY());
            case LEFT -> antPosition = Point.of(antPosition.getX(), antPosition.getY() - 1);
        }
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

    enum Direction {
        LEFT,
        UP,
        RIGHT,
        DOWN
    }

    enum Movement {
        LEFT,
        RIGHT
    }

}
