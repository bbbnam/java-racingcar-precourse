package racingGame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validateSize(cars);
        this.cars = Collections.unmodifiableList(cars);
    }

    private void validateSize(List<Car> cars) {
        if (cars.size() < 2) {
            throw new IllegalArgumentException("자동차 게임은 최소 차 2대 이상은 되어야 합니다.");
        }
    }

    public Cars moveAll(MoveStrategy moveStrategy) {
        List<Car> movedCars = new ArrayList<>();
        for (Car car : cars) {
            movedCars.add(car.move(moveStrategy));
        }
        return new Cars(movedCars);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public Car findMaxPosition() {
        return Collections.max(cars);
    }

    public List<Car> findSamePosition(Car max) {
        List<Car> findedCars = new ArrayList<>();
        for (Car car : cars) {
            Optional<Car> winner = car.samePosition(max);
            winner.ifPresent(findedCars::add);
        }
        return findedCars;
    }
}
