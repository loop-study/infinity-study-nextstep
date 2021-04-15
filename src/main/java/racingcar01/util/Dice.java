package racingcar01.util;

import java.util.Random;

public class Dice {
    private static final int NUMBER_LENGTH = 10;
    private static final Random random = new Random();

    private Dice() { }

    public static int random() {
        return random.nextInt(NUMBER_LENGTH);
    }
}
