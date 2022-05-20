package com.tddkata.GossipingBusDriversKata;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class GossipCalculatorShould {

    private final GossipCalculator gossipCalculator = new GossipCalculator();

    @Test
    void return_one_when_two_drivers_have_same_and_only_one_route() {
        final List<BusDriver> busDrivers = List.of(
                new BusDriver(List.of(1)),
                new BusDriver(List.of(1)));

        assertThat(gossipCalculator.whenShareAllGossips(busDrivers)).isEqualTo("1");
    }

    @Test
    void return_two_when_two_drivers_have_meet_minute_one() {
        final List<BusDriver> busDrivers = List.of(
                new BusDriver(List.of(1, 2)),
                new BusDriver(List.of(4, 2)));

        assertThat(gossipCalculator.whenShareAllGossips(busDrivers)).isEqualTo("2");
    }

    @Test
    void return_six_when_two_drivers_have_meet_minute_five() {
        final List<BusDriver> busDrivers = List.of(
                new BusDriver(List.of(1, 2, 3, 4, 5, 6)),
                new BusDriver(List.of(9, 8, 7, 6, 6, 6)));

        assertThat(gossipCalculator.whenShareAllGossips(busDrivers)).isEqualTo("6");
    }

    @Test
    void return_never_when_two_drives_never_meet() {
        final List<BusDriver> busDrivers = List.of(
                new BusDriver(List.of(1, 2, 3, 4, 5, 6)),
                new BusDriver(List.of(9, 8, 7, 6, 6, 9)));

        assertThat(gossipCalculator.whenShareAllGossips(busDrivers)).isEqualTo("never");
    }

    @Test
    void return_never_when_two_drives_meet_after_480_minutes() {
        List<Integer> route1 = createRoute(1, 480);
        List<Integer> route2 = createRoute(2, 480);
        route1.add(3);
        route2.add(3);

        final List<BusDriver> busDrivers = List.of(
                new BusDriver(route1),
                new BusDriver(route2));

        assertThat(gossipCalculator.whenShareAllGossips(busDrivers)).isEqualTo("never");
    }

    @Test
    void return_five_when_three_drives_meet_a_minute_five() {
        final List<BusDriver> busDrivers = List.of(
                new BusDriver(List.of(3, 1, 2, 3)),
                new BusDriver(List.of(3, 2, 3, 1)),
                new BusDriver(List.of(4, 2, 3, 4, 5)));

        assertThat(gossipCalculator.whenShareAllGossips(busDrivers)).isEqualTo("5");
    }

    private List<Integer> createRoute(int value, int length) {
        List<Integer> route = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            route.add(value);
        }
         return route;
    }

}