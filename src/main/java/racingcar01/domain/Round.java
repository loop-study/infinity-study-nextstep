package racingcar01.domain;

public class Round {
    private static final String ROUND_MIN_MASSAGE = "진행 횟수는 0보다 커야합니다.";
    private static final int ROUND_END = 0;
    private static final int ROUND_MINUS = 1;

    private final int round;

    private Round(int round) {
        this.round = round;
    }

    public static Round of(int round) {
        validRoundMin(round);
        return new Round(round);
    }

    public Round next() {
        return of(round - ROUND_MINUS);
    }

    public boolean isEnd() {
        return ROUND_END == round;
    }

    private static void validRoundMin(int round) {
        if (ROUND_END > round) {
            throw new IllegalArgumentException(ROUND_MIN_MASSAGE);
        }
    }
}
