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

    public String getName() {
        return name;
    }

    public int getDay() {
        return day;
    }

    public String getDate() {
        return date;
    }

    public boolean isRestDay() {
        return isRestDay;
    }

    public void addEmployee(String name) {
        this.name = name;
    }
}
