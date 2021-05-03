package racingGame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TryCountTest {

    @DisplayName("자동차 게임 진행 시도 횟수 테스트 - 정상 생성의 경우")
    @ParameterizedTest
    @ValueSource(ints = {1, 10, 100, Integer.MAX_VALUE})
    void createTryCount(int count) {
        TryCount tryCount = new TryCount(count);

        assertThat(tryCount.getValue()).isEqualTo(count);
    }

    @DisplayName("자동차 게임 진행 시도 횟수 테스트 - 0 또는 음수는 올 수 없음[0 또는 음수일때 예외발생]")
    @ParameterizedTest
    @ValueSource(ints = {0, -1, -10, Integer.MIN_VALUE})
    void validateTryCount(int count) {
        assertThatThrownBy(() -> new TryCount(count))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 적어도 1보단 커야 합니다.");
    }
}
