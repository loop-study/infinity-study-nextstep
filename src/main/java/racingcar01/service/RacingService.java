package racingcar01.service;

import racingcar01.domain.Cars;
import racingcar01.domain.Records;
import racingcar01.domain.Round;

public class RacingService {

    public Records play(Round round, Cars cars) {
        Records records = new Records();

        while (!round.isEnd()) {
            round = round.next();
            cars = cars.moved();
            records.addRecord(cars);
        }

        return records;
    }
}
