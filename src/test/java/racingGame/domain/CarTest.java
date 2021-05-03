package racingGame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private final  Car car = new Car("자동차1", 0);

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
}
