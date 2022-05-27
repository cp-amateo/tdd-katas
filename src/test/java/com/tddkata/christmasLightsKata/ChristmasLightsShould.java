package com.tddkata.christmasLightsKata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ChristmasLightsShould {

    private ChristmasLights christmasLights;

    @BeforeEach
    void setUp() {
        christmasLights = new ChristmasLights();
    }

    @Test
    void turn_off_all_lights() {

        christmasLights.turnOff(Coordinate.of(0, 0), Coordinate.of(0.0));

        assertThat(christmasLights.getLightsLit()).isEqualTo(0);
    }
}