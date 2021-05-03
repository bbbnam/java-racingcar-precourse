package racingGame.domain;

import java.util.Objects;

public class Name {
    private static final int NAME_LIMIT = 5;
    private static final String NAME_LIMIT_MESSAGE = "이름은 5자 이하만 가능합니다.";

    private final String name;

    public Name(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.length() > NAME_LIMIT) {
            throw new IllegalArgumentException(NAME_LIMIT_MESSAGE);
        }
    }

    public String getValue() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
