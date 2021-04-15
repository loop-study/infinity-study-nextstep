package racingcar01.view;

import java.util.Scanner;

public class InputView {
    private static final String CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String ROUND_MESSAGE = "시도할 회수는 몇회인가요?";

    private static final Scanner scanner = new Scanner(System.in);

    public String names() {
        System.out.println(CAR_NAME_MESSAGE);
        return scanner.nextLine();
    }

    public int round() {
        System.out.println(ROUND_MESSAGE);
        return Integer.parseInt(scanner.nextLine());
    }
}
