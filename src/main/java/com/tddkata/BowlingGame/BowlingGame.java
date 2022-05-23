package com.tddkata.BowlingGame;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BowlingGame {

    @RequiredArgsConstructor
    @Getter
    class Frame {
        private final Integer roll1;
        private final Integer roll2;

        public boolean isSpare() {
            return roll1 + roll2 == 10;
        }

        public int baseScore() {
            return roll1 + roll2;
        }
    }

    public static final int PINS_IN_GAME = 10;
    private final List<Integer> rolls = new ArrayList<>();

    public void roll(int pins) {
        if (pins > PINS_IN_GAME || pins < 0) {
            throw new RuntimeException();
        }
        rolls.add(pins);
    }

    public int score() {
        List<Frame> frames = buildFrames ();

        int baseScore = frames.stream().mapToInt(Frame::baseScore).sum();

        int bonus = 0;
        for (int frameNumber = 0; frameNumber < frames.size() -1; frameNumber++) {
            if (frames.get(frameNumber).isSpare()) {
                bonus += frames.get(frameNumber + 1).getRoll1();
            }
        }

        return baseScore + bonus;
    }

    private List<Frame> buildFrames() {
        List<Frame> frames = new ArrayList<>();
        for (int rollNumber = 0; rollNumber < rolls.size(); rollNumber += 2) {
            frames.add(new Frame(rolls.get(rollNumber), rolls.get(rollNumber + 1)));
        }
        return frames;
    }


}
