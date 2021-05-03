package racingGame.domain;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {
    private static final int RANDOM_LIMIT = 10;
    private static final int TRUE_CONDITION_MIN = 4;

    private final Random random = new Random();

    @Override
    public boolean isMoveable() {
        return random.nextInt(RANDOM_LIMIT) >= TRUE_CONDITION_MIN;
    }
}
