package racingGame.domain;

public class TryCount {
    private static final int TRY_COUNT_MIN = 1;
    private static final String TRY_COUNT_MIN_MESSAGE = "시도 횟수는 적어도 1보단 커야 합니다.";

    private final int count;

    public TryCount(int count) {
        validateTryCount(count);
        this.count = count;
    }

    private void validateTryCount(int tryCount) {
        if (tryCount < TRY_COUNT_MIN) {
            throw new IllegalArgumentException(TRY_COUNT_MIN_MESSAGE);
        }
    }

    public boolean hasNext(int actualTry) {
        return actualTry < count;
    }

    public int getValue() {
        return count;
    }
}
