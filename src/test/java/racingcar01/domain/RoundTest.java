package racingcar01.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class RoundTest {

    @ParameterizedTest
    @CsvSource(value = {"1","2","3","4"})
    public void 라운드_진행_확인(int initRound) throws Exception {
        Round round = Round.of(initRound);

        boolean result = round.next().isEnd();
        
        assertThat(result).isFalse();
    }

    @Test
    public void 라운드_종료_확인() throws Exception {
        Round round = Round.of(1);

        boolean result = round.next().isEnd();

        assertThat(result).isTrue();
    }

    @Test
    public void 라운드_에러_확인() throws Exception {
        assertThatThrownBy(() -> Round.of(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
