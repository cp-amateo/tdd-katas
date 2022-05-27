package com.tddkata.christmasLightsKata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class ChristmasLightsShould {

    private ChristmasLights christmasLights;

    @BeforeEach
    void setUp() {
        christmasLights = new ChristmasLights();
    }

    @Test
    void turn_off_all_lights() {
        christmasLights.turnOff(Coordinate.of(0, 0), Coordinate.of(999, 999));

        assertThat(christmasLights.getNumberOfLightsOn()).isEqualTo(0);
    }

    @Test
    void turn_on_all_lights() {
        christmasLights.turnOn(Coordinate.of(0, 0), Coordinate.of(999, 999));

        assertThat(christmasLights.getNumberOfLightsOn()).isEqualTo(1000000);
    }

    @Test
    void return_2000_when_turn_on_first_two_rows() {
        christmasLights.turnOn(Coordinate.of(0, 0), Coordinate.of(1, 999));

        assertThat(christmasLights.getNumberOfLightsOn()).isEqualTo(2000);
    }

    @Test
    void return_0_when_turn_off_all_lights_after_turn_on_all() {
        christmasLights.turnOn(Coordinate.of(0, 0), Coordinate.of(999, 999));
        christmasLights.turnOff(Coordinate.of(0, 0), Coordinate.of(999, 999));

        assertThat(christmasLights.getNumberOfLightsOn()).isEqualTo(0);
    }
}