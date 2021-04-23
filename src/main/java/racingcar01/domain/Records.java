package racingcar01.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Records {
    private List<Record> records = new ArrayList<>();

    public void addRecord(Cars cars) {
        records.add(new Record(cars));
    }

    public void forEach(Consumer<? super Record> records) {
        this.records.forEach(records);
    }

    public List<Car> winners() {
        int maxDistance = maxDistance();

        return lastOfRecord().cars().cars().stream()
                .filter(car -> car.isMaxDistance(maxDistance))
                .collect(Collectors.toList());
    }

    private Record lastOfRecord() {
        return records.get(records.size() - 1);
    }

    private int maxDistance() {
        return lastOfRecord().cars().cars().stream()
                .mapToInt(Car::distance)
                .max()
                .getAsInt();
    }
}
