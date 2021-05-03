package racingGame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

class WinnersTest {

    private final Car car1 = new Car("자동차1", 2);
    private final Car car2 = new Car("자동차2", 1);
    private final Car car3 = new Car("자동차3", 2);

    @DisplayName("우승자 찾기 테스트")
    @Test
    void findWinner() {
        Cars records = new Cars(asList(car1, car2, car3));

        Winners winners = new Winners(records);
        List<Car> results = winners.findWinner();

        assertThat(results).containsExactly(car1, car3);
    }
}