package racingGame.domain;

import java.util.Objects;
import java.util.Optional;

public class Car implements Comparable<Car> {
    private static final int NAME_LIMIT = 5;
    private static final int POSITION_MIN = 0;
    private static final String NAME_LIMIT_MESSAGE = "이름은 5자 이하만 가능합니다.";
    private static final String POSITION_MIN_MESSAGE = "이동상태(position) 값은 음수가 될 수 없습니다.";

    private final String name;
    private int position;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        validateName(name);
        validatePosition(position);
        this.name = name;
        this.position = position;
    }

    private void validateName(String name) {
        if (name.length() > NAME_LIMIT) {
            throw new IllegalArgumentException(NAME_LIMIT_MESSAGE);
        }
    }

    private void validatePosition(int position) {
        if (position < POSITION_MIN) {
            throw new IllegalArgumentException(POSITION_MIN_MESSAGE);
        }
    }

    public Car move(MoveStrategy moveStrategy) {
        if (moveStrategy.isMoveable()) {
            position++;
        }
        return new Car(this.name, this.position);
    }

    public Optional<Car> samePosition(Car maxPositionCar) {
        if (this.position == maxPositionCar.position) {
            return Optional.of(this);
        }
        return Optional.empty();
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public int compareTo(Car other) {
        return this.position - other.position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position &&
                Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
