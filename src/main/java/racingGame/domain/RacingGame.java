package racingGame.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private static final int TRY_COUNT_MIN = 1;
    private static final String TRY_COUNT_MIN_MESSAGE = "시도 횟수는 적어도 1보단 커야 합니다.";

    private final Cars cars;
    private final int tryCount;

    public RacingGame(List<String> carNames, int tryCount) {
        validateTryCount(tryCount);
        this.cars = initCars(carNames);
        this.tryCount = tryCount;
    }

    private void validateTryCount(int tryCount) {
        if (tryCount < TRY_COUNT_MIN) {
            throw new IllegalArgumentException(TRY_COUNT_MIN_MESSAGE);
        }
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
        while (actualTry < tryCount) {
            results.add(cars.moveAll(moveStrategy));
            actualTry++;
        }
        return results;
    }
}
