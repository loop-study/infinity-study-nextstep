package racingcar01.domain;

import racingcar01.util.Dice;

public class CarMove implements MoveStrategy {
    private static final int MOVE_CONDITION = 4;

    private static final CarMove INSTANCE = new CarMove();

    private CarMove() { }

    public static CarMove init() {
        return INSTANCE;
    }

    @Override
    public boolean isMoveable() {
        return MOVE_CONDITION <= Dice.random();
    }
}
