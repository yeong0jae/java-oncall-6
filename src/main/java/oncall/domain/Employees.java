package oncall.domain;

import java.util.Collections;
import java.util.List;
import oncall.util.ErrorMessage;

public class Employees {

    private final List<Employee> employees;

    public Employees(List<String> employeeNames) {
        validateDuplicate(employeeNames);
        validateSize(employeeNames);
        this.employees = employeeNames.stream()
                .map(Employee::new)
                .toList();
    }

    private void validateDuplicate(List<String> employeeNames) {
        employeeNames.forEach(employeeName -> {
            if (Collections.frequency(employeeNames, employeeName) >= 2) {
                throw new IllegalArgumentException(ErrorMessage.PREFIX + "유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
            }
        });
    }

    private void validateSize(List<String> employeeNames) {
        if (employeeNames.size() < 5 || employeeNames.size() > 35) {
            throw new IllegalArgumentException(ErrorMessage.PREFIX + "유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
        }
    }
}
