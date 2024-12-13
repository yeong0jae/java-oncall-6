package oncall.domain;

public class OneDay {
    private final String date; // 일
    private final String day; // 요일
    private final String name; // 근무자 이름

    public OneDay(String date, String day, String name) {
        this.date = date;
        this.day = day;
        this.name = name;
    }
}
