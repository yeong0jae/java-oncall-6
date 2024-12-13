package oncall.domain;

public class Schedule {
    private final int day;
    private final String date;
    private final boolean isRestDay;
    private String name;

    public Schedule(int day, String date, boolean isRestDay) {
        this.day = day;
        this.date = date;
        this.isRestDay = isRestDay;
    }


}
