package lotto01.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

@DisplayName("로또 번호")
public class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {1,2,44,45})
    public void 로또번호_1부터_45까지_만든다(int number) throws Exception {
        LottoNumber lottoNumber = LottoNumber.of(number);
        assertThat(lottoNumber.toInt()).isEqualTo(number);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    public void 로또번호_1과_45를_벗어나면_예외처리(int number) throws Exception {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoNumber.of(number));
    }
}
