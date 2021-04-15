package racingcar01.domain;

public class Car {
    private static final int DEFAULT_DISTANCE = 0;

    private final Name name;
    private final Distance distance;

    private Car(Name name) {
        this(name, Distance.of(DEFAULT_DISTANCE));
    }

    private Car(Name name, Distance distance) {
        this.name = name;
        this.distance = distance;
    }

    public static Car of(String name) {
        return new Car(Name.of(name));
    }

    public Car movedCar(MoveStrategy move) {
        if (move.isMoveable()) {
            return new Car(name, distance.add());
        }
        return this;
    }

    public String name() {
        return name.name();
    }

    public int distance() {
        return distance.distance();
    }
}
