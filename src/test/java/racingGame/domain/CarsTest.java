package racingGame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarsTest {

    @DisplayName("자동차들 객체 전체 이동 -> 이동조건이 무조건 참일때")
    @Test
    void moveAll() {
        Cars cars = new Cars(Arrays.asList(new Car("자동차1", 0),
                new Car("자동차2", 0), new Car("자동차3", 0)));

        cars = cars.moveAll(() -> true);

        assertThat(cars.getCars()).containsExactly(new Car("자동차1", 1),
                new Car("자동차2", 1), new Car("자동차3", 1));
    }

    @DisplayName("자동차들 객체 전체 이동x(멈춤) -> 이동조건이 무조건 거짓일때")
    @Test
    void notMoveAll() {
        Cars cars = new Cars(Arrays.asList(new Car("자동차1", 0),
                new Car("자동차2", 0), new Car("자동차3", 0)));

        cars = cars.moveAll(() -> false);

        assertThat(cars.getCars()).containsExactly(new Car("자동차1", 0),
                new Car("자동차2", 0), new Car("자동차3", 0));
    }

    @DisplayName("자동차 최소 대수 테스트 - 1대 이상이어야 함")
    @Test
    void validateCarsSize() {
        assertThatThrownBy(
                () -> new Cars(Collections.singletonList((new Car("자동차1", 0))))
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 게임은 최소 차 2대 이상은 되어야 합니다.");
    }
}
