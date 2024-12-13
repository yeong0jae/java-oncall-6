package oncall.domain;

import java.util.Arrays;

public enum LegalHolidays {
    THEOCRACY(1, 1),
    THREE_ONE(3, 1),
    CHILDREN(5, 5),
    MEMORIAL(6, 6),
    LIBERATION(8, 15),
    NATIONAL_FOUNDATION(10, 3),
    HANGUL(10, 9),
    CHRISTMAS(12, 25);

    private final int month;
    private final int date;

    LegalHolidays(int month, int date) {
        this.month = month;
        this.date = date;
    }

    public static boolean isIn(int month, int day) {
        return Arrays.stream(values())
                .anyMatch(holiday -> holiday.getMonth() == month && holiday.getDate() == day);
    }

    public int getMonth() {
        return month;
    }

    public int getDate() {
        return date;
    }
}
