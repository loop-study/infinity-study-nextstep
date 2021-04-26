package racingcar01.domain;

public class Record {
    private final Cars cars;

    public Record(Cars cars) {
        this.cars = cars;
    }

    public Cars cars() {
        return cars;
    }
}
