package lotto01.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicket {
    private static final int DEFAULT_NUMBERS_SIZE = 6;
    private static final String DEFAULT_NUMBERS_SIZE_MASSAGE = "로또 번호는 6개 입니다.";
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final List<Integer> DEFAULT_NUMBERS = IntStream.rangeClosed(MIN_NUMBER, MAX_NUMBER)
                                                                .boxed()
                                                                .collect(Collectors.toList());

    private final List<LottoNumber> lottoNumbers;

    private LottoTicket(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoTicket of() {
        return new LottoTicket(createLottoNumbers(shuffleNumbers()));
    }

    public static LottoTicket of(List<Integer> manual) {
        validateNumbersSize(manual);
        return new LottoTicket(createLottoNumbers(manual));
    }

    public List<LottoNumber> lottoNumbers() {
        return lottoNumbers;
    }

    private static void validateNumbersSize(List<Integer> manual) {
        Set<Integer> validNumbers = new HashSet<>();
        validNumbers.addAll(manual);

        if (validNumbers.size() != DEFAULT_NUMBERS_SIZE) {
            throw new IllegalArgumentException(DEFAULT_NUMBERS_SIZE_MASSAGE);
        }
    }

    private static List<Integer> shuffleNumbers() {
        Collections.shuffle(DEFAULT_NUMBERS);

        List<Integer> numbers = DEFAULT_NUMBERS.stream()
                                    .limit(6)
                                    .collect(Collectors.toList());

        Collections.sort(numbers);

        return numbers;
    }

    private static List<LottoNumber> createLottoNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::of)
                .collect(Collectors.toList());
    }
}
