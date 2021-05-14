package lotto01.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

@DisplayName("당첨 번호")
public class WinnerNumbersTest {

    @Test
    public void 당첨번호_생성() throws Exception {
        WinnerNumbers winnerNumbers = new WinnerNumbers(LottoTicket.of(Arrays.asList(1,2,3,4,5,6)), 7);
        assertThat(winnerNumbers).isNotNull();
    }
}
