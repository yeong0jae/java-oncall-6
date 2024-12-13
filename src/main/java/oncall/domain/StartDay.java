package oncall.domain;

import java.util.List;
import oncall.util.ErrorMessage;

public class StartDay {
    private final String month;
    private final String day;

    public StartDay(List<String> startDay) {
        validateMonth(startDay.get(0));
        validateDay(startDay.get(1));
        this.month = startDay.get(0);
        this.day = startDay.get(1);
    }

    private void validateMonth(String inputMonth) {
        if (!Calendar.isIn(inputMonth)) {
            throw new IllegalArgumentException(ErrorMessage.PREFIX + "유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
        }
    }

    private void validateDay(String inputDay) {
        if (!Day.isIn(inputDay)) {
            throw new IllegalArgumentException(ErrorMessage.PREFIX + "유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
        }
    }
}
