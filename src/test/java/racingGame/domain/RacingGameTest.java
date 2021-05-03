package racingGame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;


class RacingGameTest {

    @DisplayName("게임 시작 후 정상 결과 리턴하는지 테스트")
    @Test
    void start() {
        List<String> names = asList("pobi", "crong", "honux");
        int tryCount = 3;

        RacingGame racingGame = new RacingGame(names, tryCount);
        List<Cars> records = racingGame.start(new RandomMoveStrategy());

        assertThat(records).hasSize(3);
    }
}
