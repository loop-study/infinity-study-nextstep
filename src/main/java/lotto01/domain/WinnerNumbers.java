package lotto01.domain;

public class WinnerNumbers {

    private LottoTicket winnerTicket;
    private LottoNumber bonusBall;

    public WinnerNumbers(LottoTicket winnerTicket, LottoNumber bonusBall) {
        this.winnerTicket = winnerTicket;
        this.bonusBall = bonusBall;
    }
}
