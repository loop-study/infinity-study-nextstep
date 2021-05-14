package lotto01.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

@DisplayName("당첨")
public class LottoRankTest {

    private WinnerNumbers winnerNumbers;

    @BeforeEach
    public void setUp() {
        winnerNumbers = new WinnerNumbers(LottoTicket.of(Arrays.asList(1,2,3,4,5,6)), LottoNumber.of(7));
    }

    @Test
    public void 로또_꽝_당첨() throws Exception {
        LottoTicket ticket = LottoTicket.of(Arrays.asList(10,11,12,13,14,15));
        assertThat(LottoRank.valueOf(ticket, winnerNumbers)).isEqualTo(LottoRank.MISS);
    }
}
