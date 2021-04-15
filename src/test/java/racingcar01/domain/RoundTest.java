package racingcar01.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class RoundTest {

    @ParameterizedTest
    @CsvSource(value = {"2,1", "3,2", "4,3", "5,4"})
    public void 라운드_진행(int initRound, int result) throws Exception {
        Round round = Round.of(initRound);

        Round nextRound = round.next();

        assertThat(nextRound.round()).isEqualTo(result);
    }

    @Test
    public void 라운드_종료_TRUE() throws Exception {
        Round round = Round.of(1);

        boolean result = round.next().isLastRound();

        assertThat(result).isTrue();
    }

    @Test
    public void 라운드_종료_FALSE() throws Exception {
        Round round = Round.of(2);

        boolean result = round.next().isLastRound();

        assertThat(result).isFalse();
    }

    @Test
    public void 라운드_에러확인() throws Exception {
        assertThatThrownBy(() -> Round.of(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
