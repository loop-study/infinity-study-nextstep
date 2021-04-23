package racingcar01.domain;

public class Name {
    private static final String MAX_LENGTH_NAME_MESSAGE = "이름은 최대 5글자 입니다.";
    private static final int MAX_LENGTH_NAME = 5;

    private final String name;

    private Name(String name) {
        this.name = name;
    }

    public static Name of(String name) {
        validNameMaxLength(name);
        return new Name(name);
    }

    public String value() {
        return name;
    }

    private static void validNameMaxLength(String name) {
        if (name.length() > MAX_LENGTH_NAME) {
            throw new IllegalArgumentException(MAX_LENGTH_NAME_MESSAGE);
        }
    }
}
