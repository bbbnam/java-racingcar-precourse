package racingGame;

import racingGame.domain.*;
import racingGame.view.InputView;
import racingGame.view.OutputView;

import java.util.List;

public class GameLauncher {

    private static final InputView inputView = InputView.getInstance();
    private static final OutputView outputView = OutputView.getInstance();

    private static List<Cars> progressGame(List<String> names, TryCount tryCount) {
        RacingGame racingGame = new RacingGame(names, tryCount);
        return racingGame.start(new RandomMoveStrategy());
    }

    private static List<Car> decideWinner(List<Cars> records) {
        Cars lastRecord = records.get(records.size() - 1);
        Winners winners = new Winners(lastRecord);
        return winners.findWinner();
    }

    public static void main(String[] args) {
        List<String> names = inputView.inputCarNames();
        TryCount tryCount = new TryCount(inputView.inputTryCount());

        List<Cars> records = progressGame(names, tryCount);
        outputView.printRecords(records);

        List<Car> winners = decideWinner(records);
        outputView.printWinners(winners);
    }
}
