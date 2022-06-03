package com.tddkata.langstonAnt;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@EqualsAndHashCode
@ToString
public class Point {

    private final int x;
    private final int y;

    public static Point of(int x, int y) {
        return Point.builder()
                .x(x)
                .y(y)
                .build();
    }
}
