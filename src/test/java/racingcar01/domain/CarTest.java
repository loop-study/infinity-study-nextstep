package racingcar01.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("자동차")
public class CarTest {

    @Test
    public void car_이동() throws Exception {
        Car car = Car.of("loop");

        int distance = car.movedCar(() -> true).distance();

        assertThat(distance).isEqualTo(1);
    }

    @Test
    public void car_이동안함() throws Exception {
        Car car = Car.of("loop");

        int distance = car.movedCar(() -> false).distance();

        assertThat(distance).isEqualTo(0);
    }
}
