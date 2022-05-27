package com.tddkata.christmasLightsKata;

import lombok.Getter;

enum LIGHT_STATUS {
    OFF(0),
    ON(1);

    @Getter
    private final int value;

    LIGHT_STATUS(int value) {
        this.value = value;
    }
}
