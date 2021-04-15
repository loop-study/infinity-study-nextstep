package racingcar01.view;

import racingcar01.domain.Car;
import racingcar01.domain.Cars;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {
    private static final String START_MESSAGE = "실행 결과";

    public ResultView() {
        System.out.println(START_MESSAGE);
    }

    public void racingBoard(Cars cars) {
        System.out.println();
        cars.forEach(this::printCar);
    }

    private void printCar(Car car) {
        String name = String.format("%5s", car.name());
        System.out.println(name + " : " + printDistance(car));
    }

    private String printDistance(Car car) {
        StringBuilder builder = new StringBuilder();

        IntStream.range(0, car.distance())
                .forEach(index -> builder.append("-"));

        return builder.toString();
    }

    public void racingWinners(Cars cars) {
        System.out.println();
        System.out.println(carsToName(cars.winners()) + "가 최종 우승했습니다.");
    }

    private String carsToName(List<Car> cars) {
        List<String> winners = cars.stream()
                                    .map(Car::name)
                                    .collect(Collectors.toList());

        return String.join(",", winners);
    }
}
