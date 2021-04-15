package racingcar01.domain;

public class Round {
    private static final int ROUND_END = 0;
    private static final String ROUND_MIN_MASSAGE = "진행 횟수는 0보다 커야합니다.";

    private final int round;

    private Round(int round) {
        this.round = round;
    }

    public static Round of(int round) {
        validRoundMin(round);
        return new Round(round);
    }

    public Round next() {
        return of(round - 1);
    }

    public boolean isLastRound() {
        return ROUND_END == round;
    }

    public int round() {
        return round;
    }

    private static void validRoundMin(int round) {
        if (ROUND_END > round) {
            throw new IllegalArgumentException(ROUND_MIN_MASSAGE);
        }
    }
}
