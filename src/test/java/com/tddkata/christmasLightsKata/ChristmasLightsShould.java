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

        assertThat(christmasLights.getBrightness()).isEqualTo(0);
    }

    @Test
    void turn_on_all_lights() {
        christmasLights.turnOn(Coordinate.of(0, 0), Coordinate.of(999, 999));

        assertThat(christmasLights.getBrightness()).isEqualTo(1000000);
    }

    @Test
    void return_2000_when_turn_on_first_two_rows() {
        christmasLights.turnOn(Coordinate.of(0, 0), Coordinate.of(1, 999));

        assertThat(christmasLights.getBrightness()).isEqualTo(2000);
    }

    @Test
    void return_0_when_turn_off_all_lights_after_turn_on_all() {
        christmasLights.turnOn(Coordinate.of(0, 0), Coordinate.of(999, 999));
        christmasLights.turnOff(Coordinate.of(0, 0), Coordinate.of(999, 999));

        assertThat(christmasLights.getBrightness()).isEqualTo(0);
    }

    @Test
    void toggle_all_lights() {
        christmasLights.toggle(Coordinate.of(0, 0), Coordinate.of(999, 999));

        assertThat(christmasLights.getBrightness()).isEqualTo(2000000);
    }

    @Test
    void exercise() {
        christmasLights.turnOn(Coordinate.of(887, 9), Coordinate.of(959,629));
        christmasLights.turnOn(Coordinate.of(454,398), Coordinate.of(844,448));
        christmasLights.turnOff(Coordinate.of(539,243), Coordinate.of(559,965));
        christmasLights.turnOff(Coordinate.of(370,819), Coordinate.of(676,868));
        christmasLights.turnOff(Coordinate.of(145,40), Coordinate.of(370,997));
        christmasLights.turnOff(Coordinate.of(301,3), Coordinate.of(808,453));
        christmasLights.turnOn(Coordinate.of(351,678), Coordinate.of(951,908));
        christmasLights.toggle(Coordinate.of(720,196), Coordinate.of(897,994));
        christmasLights.toggle(Coordinate.of(831,394), Coordinate.of(904,860));

        assertThat(christmasLights.getBrightness()).isEqualTo(539560);
    }
}