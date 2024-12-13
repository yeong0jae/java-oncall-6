package oncall.domain;

import java.util.List;
import java.util.stream.Stream;
import oncall.util.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class EmployeesTest {

    @DisplayName("중복된 근무자 이름을 추가하면 예외 처리한다.")
    @Test
    void validateDuplicateTest() {
        List<String> employeeNames = List.of("포비", "포비", "제이슨");

        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new Employees(employeeNames))
                .withMessage(ErrorMessage.PREFIX + "유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
    }

    @DisplayName("근무자 수가 5명 미만, 35명 초과이면 예외 처리한다.")
    @ParameterizedTest
    @MethodSource("testEmployees")
    void validateSizeTest(List<String> employees) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new Employees(employees))
                .withMessage(ErrorMessage.PREFIX + "유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
    }

    public static Stream<List<String>> testEmployees() {
        return Stream.of(
                List.of("허브", "쥬니", "포비", "영재")
        );
    }
}