package lotto01.domain;

import java.util.Arrays;

public enum LottoRank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private int matchCount;
    private int money;

    LottoRank(int matchCount, int money) {
        this.matchCount = matchCount;
        this.money = money;
    }

    public static LottoRank valueOf(WinnerNumbers winnerNumbers, LottoTicket lottoTicket) {
        LottoRank rank = Arrays.stream(LottoRank.values())
                .filter(lottoRank -> winnerNumbers.isMatchCount(lottoRank.matchCount, lottoTicket))
                .findAny()
                .orElse(LottoRank.MISS);

        if (rank == LottoRank.SECOND && !winnerNumbers.isMatchBonus(lottoTicket)) {
            return LottoRank.THIRD;
        }

        return rank;
    }
}
