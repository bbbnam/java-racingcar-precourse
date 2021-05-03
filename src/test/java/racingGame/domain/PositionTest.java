package racingGame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositionTest {

    @DisplayName("자동차 이동상태 값 정상 생성 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 5, Integer.MAX_VALUE})
    void createPosition(int position) {
        Position created = new Position(position);

        assertThat(created.getValue()).isEqualTo(position);
    }

    @DisplayName("자동차 이동상태 값은 음수가 될 수 없음")
    @ParameterizedTest
    @ValueSource(ints = {-1, -5, Integer.MIN_VALUE})
    void validatePosition(int position) {
        assertThatThrownBy(() -> new Position(position))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이동상태(position) 값은 음수가 될 수 없습니다.");
    }

    @DisplayName("이동상태 값 증가 테스트")
    @Test
    void increase() {
        Position original = new Position(0);

        Position increased = original.increase();

        assertThat(increased.getValue()).isEqualTo(1);
    }

    @DisplayName("이동상태 값 compare를 위한 빼기 테스트")
    @Test
    void subtract() {
        Position position = new Position(3);

        int result = position.subtract(new Position(1));

        assertThat(result).isEqualTo(2);
    }
}
