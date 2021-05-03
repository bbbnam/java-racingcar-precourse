package racingGame.domain;

import java.util.Objects;
import java.util.Optional;

public class Car implements Comparable<Car> {
    private static final int DEFAULT_POSITION = 0;

    private final Name name;
    private Position position;

    public Car(String name) {
        this(name, DEFAULT_POSITION);
    }

    public Car(String name, int position) {
        this(new Name(name), new Position(position));
    }

    public Car(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public Car move(MoveStrategy moveStrategy) {
        if (moveStrategy.isMoveable()) {
            position = position.increase();
        }
        return new Car(this.name, this.position);
    }

    public Optional<Car> samePosition(Car maxPositionCar) {
        if (this.position.equals(maxPositionCar.position)) {
            return Optional.of(this);
        }
        return Optional.empty();
    }

    public String getName() {
        return name.getValue();
    }

    public int getPosition() {
        return position.getValue();
    }

    @Override
    public int compareTo(Car other) {
        return this.position.subtract(other.position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name) &&
                Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
