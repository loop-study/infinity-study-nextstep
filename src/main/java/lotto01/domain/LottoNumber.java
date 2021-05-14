package lotto01.domain;

import java.util.Objects;

public class LottoNumber {
    private static final String OUT_RANGE_MASSAGE = "잘못된 로또 번호입니다.";
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 45;

    private final int number;

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber of(int number) {
        validateNumberRange(number);
        return new LottoNumber(number);
    }

    public int toInt() {
        return number;
    }

    private static void validateNumberRange(int number) {
        if (number < MIN_RANGE
            || number > MAX_RANGE) {
            throw new IllegalArgumentException(OUT_RANGE_MASSAGE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return String.format("%d", number);
    }
}
