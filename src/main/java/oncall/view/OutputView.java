package oncall.view;

import java.util.List;
import oncall.domain.Day;
import oncall.domain.LegalHolidays;
import oncall.domain.Schedule;

public class OutputView {

    public void printSchedules(int month, List<Schedule> schedules) {
        System.out.println();
        schedules.forEach(schedule -> {
            if (LegalHolidays.isIn(month, schedule.getDay()) && !Day.isWeekend(schedule.getDate())) {
                System.out.println(
                        month + "월 " + schedule.getDay() + "일 " + schedule.getDate() + "(휴일) "
                                + schedule.getName());
            } else {
                System.out.println(
                        month + "월 " + schedule.getDay() + "일 " + schedule.getDate() + " " + schedule.getName());
            }
        });
    }
}
