package lotto01.controller;

import lotto01.domain.LottoTickets;
import lotto01.domain.WinnerNumbers;
import lotto01.view.InputView;
import lotto01.view.ResultView;

import java.util.List;

public class LottoController {
    public void run() {
        // 구매 금액, 수동 수 입력
        InputView inputView = new InputView();
        int buyAmount = inputView.inputBuyAmount();
        int manualQuantity = inputView.inputManualQuantity();

        List<List<Integer>> inputManual = inputView.inputManualNumbers(manualQuantity);

        // 로또 발급
        LottoTickets autoLottoTickets = LottoTickets.of(buyAmount);
        LottoTickets manualLottoTickets = LottoTickets.of(inputManual);
        LottoTickets lottoTickets = LottoTickets.ofTickets(autoLottoTickets, manualLottoTickets);

        // 로또 번호 확인
        ResultView resultView = new ResultView(lottoTickets);
        resultView.printLottoQuantity(manualQuantity);
        resultView.printLottoTicketInfos();

        WinnerNumbers lottoWinners = inputView.inputWinnerNumber();

        // 당첨 내역 출력
        resultView.printLottoRanksInfos(lottoWinners);
        resultView.printLottoYield(lottoWinners);
    }
}




