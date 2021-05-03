package racingGame.domain;

import java.util.Objects;
import java.util.Optional;

public class Car implements Comparable<Car> {

    private final String name;
    private int position;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        validateName(name);
        this.name = name;
        this.position = position;
    }

    private void validateName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
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
