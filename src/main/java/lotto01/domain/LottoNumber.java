package lotto01.domain;

public class LottoNumber {

    private final int number;

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber of(int number) {
        return new LottoNumber(number);
    }

    public int toInt() {
        return number;
    }
}
