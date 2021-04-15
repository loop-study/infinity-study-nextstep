package racingcar01.domain;

public class Distance {
    private static final String MIN_DISTANCE_MASSAGE = "최소 거리는 0 입니다.";
    private static final int MIN_DISTANCE = 0;
    private static final int ADD_DISTANCE = 1;

    private final int distance;

    private Distance(int distance) {
        this.distance = distance;
    }

    public static Distance of(int distance) {
        validMinDistace(distance);
        return new Distance(distance);
    }

    public Distance add() {
        return of(distance + ADD_DISTANCE);
    }

    public int distance() {
        return distance;
    }

    private static void validMinDistace(int distance) {
        if (distance < MIN_DISTANCE) {
            throw new IllegalArgumentException(MIN_DISTANCE_MASSAGE);
        }
    }
}
