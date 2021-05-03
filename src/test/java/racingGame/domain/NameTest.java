package racingGame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {

    @DisplayName("자동차 이름은 5자 이하인지 테스트 - 5자 이하시 정상 생성")
    @ParameterizedTest
    @ValueSource(strings = {"crong", "honux", "pobi", "abc", "a"})
    void createCarName(String carName) {
        Name name = new Name(carName);

        assertThat(name.getValue()).isEqualTo(carName);
    }

    @DisplayName("자동차 이름은 5자 이하인지 테스트 - 5자 초과시 예외발생 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"crongs", "honux2", "pororo", "loopy&patty"})
    void validateCarName(String carName) {
        assertThatThrownBy(() -> new Name(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 5자 이하만 가능합니다.");
    }
}
