package racingGame.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class RacingGameTest {

    private RacingGame racingGame;

    @BeforeEach
    private void setUp() {
        List<String> names = asList("pobi", "crong", "honux");
        int tryCount = 3;

        racingGame = new RacingGame(names, tryCount);
    }

    @DisplayName("게임 시작 후 정상 결과 리턴하는지 테스트1")
    @Test
    void start() {
        List<Cars> records = racingGame.start(new RandomMoveStrategy());

        assertThat(records).hasSize(3);
    }

    @DisplayName("게임 시작 후 정상 결과 리턴하는지 테스트2 - 전진 조건이 무조건 참일때 정상 진행 여부 테스트")
    @Test
    void start_by_true() {
        List<Cars> records = racingGame.start(() -> true);
        Cars finalRecords = records.get(records.size() - 1);

        assertThat(finalRecords.getCars()).containsExactly(new Car("pobi", 3),
                new Car("crong", 3), new Car("honux", 3));
    }

    @DisplayName("게임 시작 후 정상 결과 리턴하는지 테스트3 - 전진 조건이 무조건 거짓일때 멈춤 여부 테스트")
    @Test
    void start_by_false() {
        List<Cars> records = racingGame.start(() -> false);
        Cars finalRecords = records.get(records.size() - 1);

        assertThat(finalRecords.getCars()).containsExactly(new Car("pobi", 0),
                new Car("crong", 0), new Car("honux", 0));
    }

    @DisplayName("자동차 게임 진행 시도 횟수 테스트 - 0 또는 음수는 올 수 없음[0 또는 음수일때 예외발생]")
    @ParameterizedTest
    @ValueSource(ints = {0, -1, -10, -Integer.MIN_VALUE})
    void validateTryCount(int tryCount) {
        List<String> carNames = asList("pobi", "crong", "honux");

        assertThatThrownBy(() -> new RacingGame(carNames, tryCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 적어도 1보단 커야 합니다.");
    }
}
