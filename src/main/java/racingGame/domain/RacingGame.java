package racingGame.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final Cars cars;
    private final TryCount tryCount;

    public RacingGame(List<String> carNames, TryCount tryCount) {
        this.cars = initCars(carNames);
        this.tryCount = tryCount;
    }

    private Cars initCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return new Cars(cars);
    }

    public List<Cars> start(MoveStrategy moveStrategy) {
        List<Cars> results = new ArrayList<>();
        int actualTry = 0;
        while (tryCount.hasNext(actualTry)) {
            results.add(cars.moveAll(moveStrategy));
            actualTry++;
        }
        return results;
    }
}
