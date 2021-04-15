package racingcar01.controller;

import racingcar01.domain.CarMove;
import racingcar01.domain.Cars;
import racingcar01.domain.Round;
import racingcar01.view.InputView;
import racingcar01.view.ResultView;

public class RacingController {

    public void run() {
        InputView inputView = new InputView();
        String inputNames = inputView.names();
        int inputRound = inputView.round();

        Cars cars = Cars.of(inputNames);
        Round round = Round.of(inputRound);

        ResultView resultView = new ResultView();

        while (!round.isEnd()) {
            round = round.next();
            cars = cars.moved();

            resultView.racingBoard(cars);
        }

        resultView.racingWinners(cars);
    }
}
