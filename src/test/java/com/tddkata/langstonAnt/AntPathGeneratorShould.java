package com.tddkata.langstonAnt;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.awt.*;

import static org.assertj.core.api.Assertions.assertThat;
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

    @Test
    void center_position_at_the_beginning() {
        final AntPathGenerator antPathGenerator = new AntPathGenerator(11);

        assertThat(antPathGenerator.getAntPosition()).isEqualTo(Point.of(5, 5));
    }

    @Test
    void moves_after_one_step() {
        final AntPathGenerator antPathGenerator = new AntPathGenerator(11);

        assertThat(antPathGenerator.getAntPosition()).isEqualTo(Point.of(4, 5));
        assertThat(antPathGenerator.getCell(4, 5)).isEqualTo(AntPathGenerator.Color.WHITE);
    }
}