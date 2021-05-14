package lotto01.view;


import lotto01.domain.*;

import java.util.Arrays;
import java.util.List;

public class ResultView {
    private static final String RESULT_WINNER_RANK = "당첨 통계";
    private static final String RESULT_WINNER_LINE = "----------";
    private static final String STRING_BONUS = ", 보너스 볼 일치";
    private static final String STRING_EMPTY = "";

    private final LottoTickets lottoTickets;

    public ResultView(LottoTickets lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public void printLottoQuantity(int manualQuantity) {
        System.out.println("수동으로 " + manualQuantity + "장, 자동으로 "  + (lottoTickets.lottoTickets().size() - manualQuantity) + "개를 구매했습니다.");
    }

    public void printLottoTicketInfos() {
        List<LottoTicket> tickets = lottoTickets.lottoTickets();

        tickets.stream()
                .forEach(ticket -> System.out.println(ticket.lottoNumbers().toString()));
    }

    public void printLottoRanksInfos(WinnerNumbers lottoWinners) {
        System.out.println(RESULT_WINNER_RANK);
        System.out.println(RESULT_WINNER_LINE);

        Arrays.asList(LottoRank.values())
                .stream()
                .forEach(lottoRank -> printLottoRank(lottoRank, lottoWinners));
    }

    public void printLottoYield(WinnerNumbers lottoWinners) {
        double yield = LottoYield.operationYield(lottoWinners, lottoTickets.lottoTickets());
        System.out.println("총 수익률은 " + String.format("%.2f", yield) + "입니다.(기준이 1이기 때문에 결과적으로 " + stringYield(yield) + "라는 의미임)");
    }

    private String stringYield(double yield) {
        return yield >= 1 ? "이익" : "손해";
    }

    public void printLottoRank(LottoRank lottoRank, WinnerNumbers lottoWinners) {
        System.out.println(lottoRank.matchCount + "개 일치 " + bonusOfString(lottoRank) + "(" + lottoRank.money + ") - " + lottoRank.winnerCount(lottoTickets.lottoTickets(), lottoWinners) + "개");
    }

    private String bonusOfString(LottoRank lottoRank) {
        if (LottoRank.SECOND == lottoRank) {
            return STRING_BONUS;
        }

        return STRING_EMPTY;
    }
}
