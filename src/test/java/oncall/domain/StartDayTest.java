package oncall.domain;

import java.util.List;
import oncall.util.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class StartDayTest {

    @DisplayName("요일[일~월]에 포함되지 않는 요일이면 예외 처리한다.")
    @Test
    void validateDayTest() {
        List<String> startDay = List.of("3", "가");

        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new StartDay(startDay))
                .withMessage(ErrorMessage.PREFIX + "유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
    }

    @DisplayName("월[1~12]에 포함되지 않는 월이면 예외 처리한다.")
    @ParameterizedTest
    @ValueSource(strings = {"0", "13"})
    void validateMonthTest(String month) {
        List<String> startDay = List.of(month, "월");

        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new StartDay(startDay))
                .withMessage(ErrorMessage.PREFIX + "유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
    }
}
