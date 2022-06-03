package com.tddkata.langstonAnt;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

class AntPathGeneratorShould {

    @Test
    void throw_exception_when_grip_is_not_odd() {
        assertThrows(IllegalArgumentException.class,
                () -> new AntPathGenerator(8).simulatePath("RL", 2));
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"", "R","L"})
    void throw_exception_when_rules_is_not_valid(String rules) {
        assertThrows(IllegalArgumentException.class,
                () -> new AntPathGenerator(11).simulatePath(rules, 2));
    }

}