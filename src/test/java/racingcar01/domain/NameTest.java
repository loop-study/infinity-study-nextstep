package racingcar01.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("이름")
public class NameTest {

    @ParameterizedTest
    @ValueSource(strings = {"s","st","stu","stud","study"})
    public void 이름_최대_5글자(String input) throws Exception {
        Name name = Name.of(input);
        assertThat(name.name()).isEqualTo(input);
    }

    @Test
    public void 이름_5글자_초과_에러() throws Exception {
        assertThatThrownBy(() -> Name.of("123456"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
