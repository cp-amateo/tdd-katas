package com.tddkata.langstonAnt;

public class AntPathGenerator {
    public AntPathGenerator(int gripSize) {
        if (gripSize % 2 == 0) {
            throw new IllegalArgumentException();
        }

    }

    public void simulatePath(final String rules, int steps) {
    }
}
