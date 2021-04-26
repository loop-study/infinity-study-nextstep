package racingcar01.strategy;

import racingcar01.util.Dice;

public class CarMove implements MoveStrategy {
    private static final int MOVE_CONDITION = 4;

    private static final CarMove INSTANCE = new CarMove();

    private CarMove() { }

    public static CarMove instance() {
        return INSTANCE;
    }

    @Override
    public boolean isMoveable() {
        return MOVE_CONDITION <= Dice.random();
    }
}
