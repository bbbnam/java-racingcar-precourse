package racingGame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        return new Cars(movedCars);    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
