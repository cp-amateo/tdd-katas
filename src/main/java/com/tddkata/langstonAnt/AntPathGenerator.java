package com.tddkata.langstonAnt;

import static java.util.Objects.isNull;

public class AntPathGenerator {
    public AntPathGenerator(int gripSize) {
        if (gripSize % 2 == 0) {
            throw new IllegalArgumentException();
        }

    }

    public void simulatePath(final String rules, int steps) {
        if (rules == null
            || rules.isEmpty()
            || rules.length() < 2) {
            throw new IllegalArgumentException();
        }
    }
}
