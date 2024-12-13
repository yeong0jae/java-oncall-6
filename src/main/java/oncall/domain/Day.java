package oncall.domain;

public enum Day {
    MON("월"),
    TUE("화"),
    WEN("수"),
    THU("목"),
    FRI("금"),
    SAT("토"),
    SUN("일");

    private final String dateName;

    Day(String dateName) {
        this.dateName = dateName;
    }
}
