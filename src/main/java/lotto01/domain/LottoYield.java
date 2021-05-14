package lotto01.domain;

import java.util.List;

public class LottoYield {
    private static final int LOTTO_TICKET_PRICE = 1000;

    public static double operationYield(WinnerNumbers winnerNumbers, LottoTickets lottoTickets) {
        List<LottoTicket> tickets = lottoTickets.lottoTickets();
        long winningAmountSum = tickets.stream()
                                    .mapToLong(lottoTicket -> LottoRank.valueOf(winnerNumbers, lottoTicket).money)
                                    .sum();

        return winningAmountSum / (tickets.size() * LOTTO_TICKET_PRICE);
    }
}
