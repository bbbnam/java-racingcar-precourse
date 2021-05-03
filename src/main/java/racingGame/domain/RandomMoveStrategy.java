package racingGame.domain;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {

    private final Random random = new Random();

    @Override
    public boolean isMoveable() {
        return random.nextInt(10) >= 4;
    }
}
