package racingGame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = Collections.unmodifiableList(cars);
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
