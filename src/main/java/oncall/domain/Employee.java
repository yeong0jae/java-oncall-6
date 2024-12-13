package oncall.domain;

import oncall.util.ErrorMessage;

public class Employee {
    private final String name;

    public Employee(String name) {
        validateLength(name);
        this.name = name;
    }

    private void validateLength(String name) {
        if (name.length() >= 5) {
            throw new IllegalArgumentException(ErrorMessage.PREFIX + "유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
        }
    }
}
