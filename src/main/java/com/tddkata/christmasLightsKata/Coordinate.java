package com.tddkata.christmasLightsKata;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Coordinate {

    private final int x;
    private final int y;

    public static Coordinate of(int x, int y) {
        return Coordinate.builder()
                .x(x)
                .y(y)
                .build();
    }
}
