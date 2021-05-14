package lotto01.domain;

public class WinnerNumbers {
    private static final String DUPLICATE_MASSAGE = "보너스 번호가 중복됩니다.";

    private LottoTicket winnerTicket;
    private LottoNumber bonusBall;

    public WinnerNumbers(LottoTicket winnerTicket, LottoNumber bonusBall) {
        validateDuplicate(winnerTicket, bonusBall);
        this.winnerTicket = winnerTicket;
        this.bonusBall = bonusBall;
    }

    public boolean isMatchCount(int matchCount, LottoTicket lottoTicket) {
        int count = (int) lottoTicket.lottoNumbers()
                        .stream()
                        .filter(lottoNumber -> winnerTicket.lottoNumbers().contains(lottoNumber))
                        .count();

        return count == matchCount;
    }

    private void validateDuplicate(LottoTicket winnerTicket, LottoNumber bonusBall) {
        if (winnerTicket.lottoNumbers().contains(bonusBall)) {
            throw new IllegalArgumentException(DUPLICATE_MASSAGE);
        }
    }
}
