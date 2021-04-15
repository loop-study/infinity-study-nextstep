package racingcar01.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @ParameterizedTest
    @ValueSource(strings = {"s","st","stu","stud","study"})
    public void car_이름_최대_5글자(String name) throws Exception {
        Car car = Car.of(name);
        assertThat(car.name()).isEquals(name);
    }

    @Test
    public void car_이름_5글자_초과_에러() throws Exception {
        assertThatThrownBy(() -> Car.of("123456"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
