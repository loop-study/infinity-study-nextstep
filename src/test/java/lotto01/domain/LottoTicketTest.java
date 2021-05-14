package lotto01.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

@DisplayName("로또 티켓")
public class LottoTicketTest {

    private List<Integer> stringToList(String inputNumbers) {
        return Arrays.stream(inputNumbers.split(","))
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .collect(Collectors.toList());
    }

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

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5", "1,2,3,4,5,6,7"})
    public void 로또_번호가_6개가_아니면_예외처리(String inputNumbers) throws Exception {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoTicket.of(stringToList(inputNumbers)));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,1,2,3,4,5", "1,2,3,5,6,6"})
    public void 로또_번호가_중복되면_예외처리(String inputNumbers) throws Exception {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoTicket.of(stringToList(inputNumbers)));
    }
}
