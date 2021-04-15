package racingcar01.domain;

public class Car {
    private static final int MAX_LENGTH_NAME = 5;
    private static final String MAX_LENGTH_NAME_MESSAGE = "이름은 최대 5글자 입니다.";

    private final String name;

    private Car(String name) {
        this.name = name;
    }

    public static Car of(String name) {
        validNameMaxLength(name);
        return new Car(name);
    }

    public String name() {
        return name;
    }

    private static void validNameMaxLength(String name) {
        if (name.length() > MAX_LENGTH_NAME) {
            throw new IllegalArgumentException(MAX_LENGTH_NAME_MESSAGE);
        }
    }
}
