package oncall.domain;

import java.util.Collections;
import java.util.List;
import oncall.util.ErrorMessage;

public class Employees {

    private final List<Employee> employees;

    public Employees(List<String> employeeNames) {
        validateDuplicate(employeeNames);
        this.employees = employeeNames.stream()
                .map(Employee::new)
                .toList();
    }

    private void validateDuplicate(List<String> employeeNames) {
        employeeNames.forEach(employeeName -> {
            if (Collections.frequency(employeeNames, employeeName) >= 2) {
                throw new IllegalArgumentException(ErrorMessage.PREFIX + "중복된 닉네임의 근무자입니다.");
            }
        });
    }
}
