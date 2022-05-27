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
}