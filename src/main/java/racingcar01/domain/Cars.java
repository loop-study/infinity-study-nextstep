package racingcar01.domain;

import racingcar01.strategy.CarMove;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Cars{

    private static final String COMMA = ",";

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars of(String names) {
        List<String> nameList = stringToList(names);
        return new Cars(createCars(nameList));
    }

    public Cars moved() {
        List<Car> movedCars = cars.stream()
                                .map(car -> car.movedCar(CarMove.instance()))
                                .collect(Collectors.toList());

        return new Cars(movedCars);
    }

    public void forEach(Consumer<? super Car> cars) {
        this.cars.forEach(cars);
    }

    public List<Car> cars() {
        return cars;
    }

    private static List<Car> createCars(List<String> nameList) {
        return nameList.stream()
                .map(Car::of)
                .collect(Collectors.toList());
    }

    private static List<String> stringToList(String names) {
        return Arrays.asList(names.split(COMMA));
    }
}
