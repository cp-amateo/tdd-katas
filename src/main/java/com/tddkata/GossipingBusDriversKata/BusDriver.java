package com.tddkata.GossipingBusDriversKata;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
@RequiredArgsConstructor
public class BusDriver {
    private final List<Integer> route;

    private final Set<Integer> gossips = new HashSet<>();

    public Integer getBusStopAtMinute(int minute) {
        return this.route.get(minute % route.size());
    }
}
