package com.tddkata.langstonAnt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import static com.tddkata.langstonAnt.AntPathGenerator.Color.BLACK;
import static com.tddkata.langstonAnt.AntPathGenerator.Color.WHITE;
import static com.tddkata.langstonAnt.AntPathGenerator.Direction.DOWN;
import static com.tddkata.langstonAnt.AntPathGenerator.Direction.LEFT;
import static com.tddkata.langstonAnt.AntPathGenerator.Direction.RIGHT;
import static com.tddkata.langstonAnt.AntPathGenerator.Direction.UP;
import static java.util.Objects.isNull;

public class AntPathGenerator {

    private final Color[][] grid;
    private Point antPosition;
    private int antDirection = 0;

    private Map<String, Supplier<Boolean>> rules = new HashMap<>();

    private final Direction[] directions = new Direction[]{LEFT, UP, RIGHT, DOWN};

    public AntPathGenerator(int gridSize) {
        grid = new Color[gridSize][gridSize];

        checkValidGridSize(gridSize);
        initializeGridAndPosition(gridSize);
        initializeRules();
    }

    private void initializeRules() {
        rules = Map.of(
                "R", this::runRuleR,
                "L", this::runRuleL);
    }

    public void simulatePath(final String command, int steps) {
        List<String> rulesList = parseRules(command);
        checkValidOrders(rulesList);
        for (int step = 0; step < steps; step++) {
            findAndApplyRules(rulesList);
            printGrid();
        }
    }

    private void printGrid() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                if (x == antPosition.getX() &&
                    y == antPosition.getY()) {
                    stringBuffer.append("x");
                } else if (WHITE == getCell(x, y)) {
                    stringBuffer.append(" ");
                } else if (BLACK == getCell(x, y)) {
                    stringBuffer.append("o");
                }
            }
            stringBuffer.append("\n");
        }
        System.out.print(stringBuffer);
    }

    private void findAndApplyRules(List<String> rulesList) {
        for (String rule : rulesList) {
            if (rules.get(rule).get()) {
                break;
            }
        }
    }

    private Boolean runRuleR() {
        if (WHITE != getCell()) {
            return false;
        }
        switchColor();
        changeDirection(Movement.RIGHT);
        moveForward();
        return true;
    }

    private Boolean runRuleL() {
        if (Color.BLACK != getCell()) {
            return false;
        }
        switchColor();
        changeDirection(Movement.LEFT);
        moveForward();
        return true;
    }

    private List<String> parseRules(final String command) {
        final List<String> rulesList = new ArrayList<>();
        if (isNull(command)) {
            return rulesList;
        }

        String rule = "";
        for (String ch : command.split("")) {
            rule = rule.concat(ch);
            if (rules.containsKey(rule)) {
                rulesList.add(rule);
                rule = "";
            }
        }
        return rulesList;
    }

    private void initializeGridAndPosition(int gridSize) {
        antPosition = Point.of(gridSize / 2, gridSize / 2);
        for (Color[] colors : grid) {
            Arrays.fill(colors, WHITE);
        }
    }

    private void checkValidGridSize(int gripSize) {
        if (gripSize % 2 == 0) {
            throw new IllegalArgumentException();
        }
    }

    private Color getCell() {
        return grid[antPosition.getX()][antPosition.getY()];
    }

    private void switchColor() {
        if (WHITE == getCell()) {
            grid[antPosition.getX()][antPosition.getY()] = Color.BLACK;
        } else if (Color.BLACK == getCell()) {
            grid[antPosition.getX()][antPosition.getY()] = WHITE;
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

    private void checkValidOrders(List<String> rules) {
        if (rules == null || rules.size() < 2) {
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
