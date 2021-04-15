package racingcar01.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @ParameterizedTest
    @ValueSource(strings = {"s","st","stu","stud","study"})
    public void car_이름_최대_5글자(String name) throws Exception {
        Car car = Car.of(name);
        assertThat(car.name()).isEqualTo(name);
    }

    @Test
    public void car_이름_5글자_초과_에러() throws Exception {
        assertThatThrownBy(() -> Car.of("123456"))
                .isInstanceOf(IllegalArgumentException.class);
    }

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
