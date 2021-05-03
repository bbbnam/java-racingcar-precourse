package racingGame;

import racingGame.domain.*;
import racingGame.view.InputView;
import racingGame.view.OutputView;

import java.util.List;

public class GameLauncher {

    private static final InputView inputView = InputView.getInstance();
    private static final OutputView outputView = OutputView.getInstance();

    public static void main(String[] args) {
        List<String> names = inputView.inputCarNames();
        int tryCount = inputView.inputTryCount();

        RacingGame racingGame = new RacingGame(names, tryCount);
        List<Cars> records = racingGame.start(new RandomMoveStrategy());
        outputView.printRecords(records);

        Cars lastRecord = records.get(records.size() - 1);
        Winners winners = new Winners(lastRecord);
        List<Car> decidedWinners = winners.findWinner();
        outputView.printWinners(decidedWinners);
    }
}
