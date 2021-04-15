package racingcar01.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class DistanceTest {

    @Test
    public void 거리_init() throws Exception {
        Distance distance = Distance.init();
        assertThat(distance.distance()).isEqualTo(0);
    }

    @Test
    public void 거리_에러() throws Exception {
        assertThatThrownBy(() -> Distance.of(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
