package lotto01.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("로또 티켓")
public class LottoTicketTest {

    @Test
    public void 로또_티켓을_생성() throws Exception {
        LottoTicket lottoTicket = LottoTicket.of();
        assertThat(lottoTicket).isNotNull();
    }

    @Test
    public void 로또_번호는_6개다() throws Exception {
        LottoTicket lottoTicket = LottoTicket.of();
        assertThat(lottoTicket.lottoNumbers().size()).isEqualTo(6);
    }
}
