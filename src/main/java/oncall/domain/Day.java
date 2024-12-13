package oncall.domain;

import java.util.Arrays;
import java.util.List;

public enum Day {
    WEEKDAYS(List.of("월", "화", "수", "목", "금")),
    WEEKENDS(List.of("토", "일"));

    private final List<String> date;

    Day(List<String> date) {
        this.date = date;
    }

    public static boolean isIn(String inputDay) {
        return Arrays.stream(values())
                .anyMatch(day -> day.getDate().contains(inputDay));
    }

    public List<String> getDate() {
        return date;
    }
}
