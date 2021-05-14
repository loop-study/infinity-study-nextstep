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
        assertThat(LottoRank.valueOf(winnerNumbers, ticket)).isEqualTo(LottoRank.MISS);
    }

    @Test
    public void 로또_5등_당첨() throws Exception {
        LottoTicket ticket = LottoTicket.of(Arrays.asList(10,11,12,3,4,5));
        assertThat(LottoRank.valueOf(winnerNumbers, ticket)).isEqualTo(LottoRank.FIFTH);
    }

    @Test
    public void 로또_4등_당첨() throws Exception {
        LottoTicket ticket = LottoTicket.of(Arrays.asList(10,11,2,3,4,5));
        assertThat(LottoRank.valueOf(winnerNumbers, ticket)).isEqualTo(LottoRank.FOURTH);
    }

    @Test
    public void 로또_3등_당첨() throws Exception {
        LottoTicket ticket = LottoTicket.of(Arrays.asList(10,1,2,3,4,5));
        assertThat(LottoRank.valueOf(winnerNumbers, ticket)).isEqualTo(LottoRank.THIRD);
    }

    @Test
    public void 로또_2등_당첨() throws Exception {
        LottoTicket ticket = LottoTicket.of(Arrays.asList(7,2,3,4,5,6));
        assertThat(LottoRank.valueOf(winnerNumbers, ticket)).isEqualTo(LottoRank.SECOND);
    }

    @Test
    public void 로또_1등_당첨() throws Exception {
        LottoTicket ticket = LottoTicket.of(Arrays.asList(1,2,3,4,5,6));
        assertThat(LottoRank.valueOf(winnerNumbers, ticket)).isEqualTo(LottoRank.FIRST);
    }
}
