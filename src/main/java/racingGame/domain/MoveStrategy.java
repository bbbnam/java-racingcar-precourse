package racingGame.domain;

@FunctionalInterface
public interface MoveStrategy {
    boolean isMoveable();
}
