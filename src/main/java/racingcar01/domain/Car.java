package racingcar01.domain;

public class Car {
    private static final String MAX_LENGTH_NAME_MESSAGE = "이름은 최대 5글자 입니다.";
    private static final int MAX_LENGTH_NAME = 5;
    private static final int DEFAULT_DISTANCE = 0;

    private final String name;
    private final Distance distance;

    private Car(String name) {
        this(name, Distance.of(DEFAULT_DISTANCE));
    }

    private Car(String name, Distance distance) {
        this.name = name;
        this.distance = distance;
    }

    public static Car of(String name) {
        validNameMaxLength(name);
        return new Car(name);
    }

    public Car movedCar(MoveStrategy move) {
        if (move.isMoveable()) {
            return new Car(name, distance.add());
        }
        return this;
    }

    public String name() {
        return name;
    }

    public int distance() {
        return distance.distance();
    }

    private static void validNameMaxLength(String name) {
        if (name.length() > MAX_LENGTH_NAME) {
            throw new IllegalArgumentException(MAX_LENGTH_NAME_MESSAGE);
        }
    }
}
