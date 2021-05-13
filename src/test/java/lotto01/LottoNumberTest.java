package lotto01;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {1,2,44,45})
    public void 로또번호_1부터_45까지_만든다(int number) throws Exception {
        LottoNumber lottoNumber = LottoNumber.of(number);
        assertThat(lottoNumber.toInt()).isEqualsTo(number);
    }
}
