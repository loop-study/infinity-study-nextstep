package racingcar01.controller;

import racingcar01.domain.Cars;
import racingcar01.domain.Records;
import racingcar01.domain.Round;
import racingcar01.service.RacingService;
import racingcar01.view.InputView;
import racingcar01.view.ResultView;

public class RacingController {
    private RacingService racingService = new RacingService();
    private InputView inputView = new InputView();
    private ResultView resultView = new ResultView();

    public void run() {
        Cars cars = inputView.names();
        Round round = inputView.round();

        Records records = racingService.play(round, cars);

        resultView.racingBoard(records);
    }
}
