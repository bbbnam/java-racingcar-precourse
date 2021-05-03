package racingGame.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @DisplayName("자동차 이름은 5자 이하인지 테스트 - 5자 초과시 예외발생 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"crongs", "honux2", "pororo", "loopy&patty"})
    void validateCarName(String carName) {
        assertThatThrownBy(() -> new Car(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 5자 이하만 가능합니다.");
    }
}
