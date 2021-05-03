package racingGame.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnersTest {

    @DisplayName("우승자 찾기 테스트")
    @Test
    void findWinner() {
        Cars records = new Cars(Arrays.asList(new Car("자동차1", 2),
                new Car("자동차2", 1), new Car("자동차3", 2)));

        Winners winners = new Winners(records);
        List<Car> results = winners.findWinner();

        assertThat(results).containsExactly(new Car("자동차1", 2), new Car("자동차3", 2));
    }
}