package oncall.domain;

import java.util.ArrayList;
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

    public static List<String> getDays(String day, int endDate) {
        List<String> weeks = Arrays.stream(values())
                .flatMap(date -> date.date.stream())
                .toList();
        int startIndex = weeks.indexOf(day);
        List<String> days = new ArrayList<>();
        for (int i = startIndex; i < startIndex + endDate; i++) {
            days.add(weeks.get(i % 7));
        }
        return days;
    }

    public static boolean isWeekend(String date) {
        return valueOf("WEEKENDS").date.stream()
                .anyMatch(it -> it.equals(date));
    }

    public List<String> getDate() {
        return date;
    }
}
