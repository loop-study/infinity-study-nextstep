package lotto01.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

@DisplayName("로또 수익률")
public class LottoYieldTest {
    private WinnerNumbers winnerNumbers;

    @BeforeEach
    public void setUp() {
        winnerNumbers = new WinnerNumbers(LottoTicket.of(Arrays.asList(1,2,3,4,5,6)), LottoNumber.of(7));
    }

    @Test
    public void 로또_수익률_이익() throws Exception {
        LottoTickets lottoTickets = new LottoTickets(Arrays.asList(LottoTicket.of(Arrays.asList(1,2,3,4,5,6))));
        boolean result = LottoYield.operationYield(winnerNumbers, lottoTickets) >= 1;
        assertThat(result).isTrue();
    }

    @Test
    public void 로또_수익률_적자() throws Exception {
        LottoTickets lottoTickets = new LottoTickets(Arrays.asList(LottoTicket.of(Arrays.asList(11,21,31,14,15,16))));
        boolean result = LottoYield.operationYield(winnerNumbers, lottoTickets) >= 1;
        assertThat(result).isFalse();
    }
}
