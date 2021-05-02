package racingGame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("자동차 객체 생성 - 이름과 이동상태를 가지고 있음")
    @Test
    void create() {
        Car car = new Car("자동차1", 0);

        assertThat(car).isEqualTo(new Car("자동차1", 0));
    }
}