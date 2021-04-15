package racingcar01.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class DistanceTest {

    @ParameterizedTest
    @CsvSource(value = {"0,1", "1,2", "2,3"})
    public void 거리_증가(int before, int after) throws Exception {
        Distance distance = Distance.of(before).add();
        assertThat(distance.distance()).isEqualTo(after);
    }

    @Test
    public void 거리_에러() throws Exception {
        assertThatThrownBy(() -> Distance.of(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
