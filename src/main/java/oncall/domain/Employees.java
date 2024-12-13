package oncall.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import oncall.util.ErrorMessage;

public class Employees {

    private List<Employee> employees = new ArrayList<>();

    public Employees(List<String> employeeNames) {
        validateDuplicate(employeeNames);
        validateSize(employeeNames);
        employeeNames.forEach(employeeName ->
                this.employees.add(new Employee(employeeName))
        );
    }

    public String popEmploy() {
        String name = employees.get(0).getName();
        employees.remove(0);
        employees.add(new Employee(name));
        return name;
    }

    public String getNameFirst() {
        return employees.get(0).getName();
    }

    public void shuffle() {
        Employee employee1 = employees.get(0);
        Employee employee2 = employees.get(1);
        employees.set(0, employee2);
        employees.set(1, employee1);
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
