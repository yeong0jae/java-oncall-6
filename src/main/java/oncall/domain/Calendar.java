package oncall.domain;

import java.util.Arrays;

public enum Calendar {
    JANUARY(1, 31),
    FEBRUARY(2, 28),
    MARCH(3, 31),
    APRIL(4, 30),
    MAY(5, 31),
    JUNE(6, 30),
    JULY(7, 31),
    AUGUST(8, 30),
    SEPTEMBER(9, 31),
    OCTOBER(10, 30),
    NOVEMBER(11, 31),
    DECEMBER(12, 30);

    private final int month;
    private final int lastDate;

    Calendar(int month, int lastDate) {
        this.month = month;
        this.lastDate = lastDate;
    }

    public static boolean isIn(String inputMonth) {
        int monthNumber = Integer.parseInt(inputMonth);
        return Arrays.stream(values())
                .map(calendar -> calendar.month)
                .anyMatch(month -> month == monthNumber);
    }
}
