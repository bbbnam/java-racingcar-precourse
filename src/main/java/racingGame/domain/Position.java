package racingGame.domain;

import java.util.Objects;

public class Position {
    private static final int POSITION_MIN = 0;
    private static final String POSITION_MIN_MESSAGE = "이동상태(position) 값은 음수가 될 수 없습니다.";

    private final int position;

    public Position(int position) {
        validatePosition(position);
        this.position = position;
    }

    private void validatePosition(int position) {
        if (position < POSITION_MIN) {
            throw new IllegalArgumentException(POSITION_MIN_MESSAGE);
        }
    }

    public Position increase() {
        return new Position(position + 1);
    }

    public int subtract(Position position) {
        return this.position - position.position;
    }

    public int getValue() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
