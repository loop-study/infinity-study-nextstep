package racingcar01.domain;

import racingcar01.strategy.MoveStrategy;

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

    public boolean isMaxDistance(int maxDistance) {
        return distance.isMaxDistance(maxDistance);
    }

    public String name() {
        return name.value();
    }

    public int distance() {
        return distance.value();
    }
}
