package com.tddkata.langstonAnt;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.EmptySource;

import static org.junit.jupiter.api.Assertions.assertThrows;

class AntPathGeneratorShould {

    @Test
    void throw_exception_when_grip_is_not_odd() {
        assertThrows(IllegalArgumentException.class,
                () -> new AntPathGenerator(8).simulatePath("RL", 2));
    }

    @Test
    void throw_exception_when_rules_is_empty() {
        assertThrows(IllegalArgumentException.class,
                () -> new AntPathGenerator(11).simulatePath("", 2));
    }

}