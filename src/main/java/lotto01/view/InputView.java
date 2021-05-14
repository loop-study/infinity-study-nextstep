package lotto01.view;

import lotto01.domain.LottoNumber;
import lotto01.domain.LottoTicket;
import lotto01.domain.WinnerNumbers;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {
    private static final String INPUT_BUY_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_MANUAL_QUANTITY_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String INPUT_MANUAL_NUMBERS_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String INPUT_WINNER_NUMBERS_MESSAGE = "방송에서 뽑힌 당첨 번호 6개를 입력해 주세요. 쉼표(,)로 구분합니다.";
    private static final String INPUT_BONUS_NUMBERS_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final String DEFAULT_SPLIT_REGEX = ",";

    private static final Scanner scanner = new Scanner(System.in);

    public int inputBuyAmount() {
        return inputInt(INPUT_BUY_AMOUNT_MESSAGE);
    }

    public int inputManualQuantity() {
        return inputInt(INPUT_MANUAL_QUANTITY_MESSAGE);
    }

    private int inputInt(String message) {
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public WinnerNumbers inputWinnerNumber() {
        System.out.println(INPUT_WINNER_NUMBERS_MESSAGE);
        List<Integer> numbers = inputNumbers();

        System.out.println(INPUT_BONUS_NUMBERS_MESSAGE);
        Integer bonus = Integer.parseInt(scanner.nextLine());
        return new WinnerNumbers(LottoTicket.of(numbers), LottoNumber.of(bonus));
    }

    private List<Integer> inputNumbers() {
        Scanner scanner = new Scanner(System.in);
        return stringToIntegers(scanner.nextLine());
    }

    public static List<Integer> stringToIntegers(String winnerNumbers) {
        return Arrays.stream(winnerNumbers.split(DEFAULT_SPLIT_REGEX))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public List<List<Integer>> inputManualNumbers(int manualQuantity) {
        if (manualQuantity > 0) {
            System.out.println(INPUT_MANUAL_NUMBERS_MESSAGE);
        }
        return Stream.generate(this::inputNumbers)
                .limit(manualQuantity)
                .collect(Collectors.toList());
    }
}
