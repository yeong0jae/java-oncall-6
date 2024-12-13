package oncall.domain;

import oncall.util.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EmployeeTest {

    @DisplayName("근무자 이름이 5자를 넘어가면 예외 처리한다.")
    @Test
    void EmployeeTest() {
        String name = "가나다라마바";

        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new Employee(name))
                .withMessage(ErrorMessage.PREFIX + "유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
    }
}
