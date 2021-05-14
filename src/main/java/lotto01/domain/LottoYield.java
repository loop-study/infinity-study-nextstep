package lotto01.domain;

import java.util.List;

public class LottoYield {
    private static final int LOTTO_TICKET_PRICE = 1000;

    public static double operationYield(WinnerNumbers winnerNumbers, List<LottoTicket> tickets) {
        long winningAmountSum = totalWinningAmount(winnerNumbers, tickets);

        return winningAmountSum / (tickets.size() * LOTTO_TICKET_PRICE);
    }

    public static long totalWinningAmount(WinnerNumbers winnerNumbers, List<LottoTicket> tickets) {
        return tickets.stream()
                .mapToLong(lottoTicket -> LottoRank.valueOf(winnerNumbers, lottoTicket).money)
                .sum();
    }
}
