package racingGame.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("자동차1", 0);
    }

    @DisplayName("자동차 객체 생성 - 이름과 이동상태를 가지고 있음")
    @Test
    void create() {
        assertThat(car).isEqualTo(new Car("자동차1", 0));
    }

    @DisplayName("자동차 이동 테스트 -> 이동조건이 무조건 참일 때 -> 이동")
    @Test
    void move() {
        assertThat(car.move(() -> true)).isEqualTo(new Car("자동차1", 1));
    }

    @DisplayName("자동차 이동 테스트 -> 이동조건이 무조건 거짓일 때 -> 멈춤")
    @Test
    void stop() {
        assertThat(car.move(() -> false)).isEqualTo(new Car("자동차1", 0));
    }

    @DisplayName("비교 대상(max_position) 자동차와 같은 이동상태(position) 값을 갖는지 테스트 - 같을때")
    @Test
    void samePosition() {
        Car maxPosition = new Car("자동차2", 0);

        Optional<Car> optCar = car.samePosition(maxPosition);

        assertThat(optCar.isPresent()).isTrue();
        assertThat(optCar.get()).isEqualTo(car);
    }

    @DisplayName("비교 대상(max_position) 자동차와 같은 이동상태(position) 값을 갖는지 테스트 - 다를때")
    @Test
    void notSamePosition() {
        Car maxPosition = new Car("자동차2", 2);

        Optional<Car> optCar = car.samePosition(maxPosition);

        assertThat(optCar.isPresent()).isFalse();
        assertThat(optCar).isEmpty();
    }
}
