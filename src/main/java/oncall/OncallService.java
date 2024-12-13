package oncall;

import java.util.ArrayList;
import java.util.List;
import oncall.domain.Calendar;
import oncall.domain.Day;
import oncall.domain.Employees;
import oncall.domain.LegalHolidays;
import oncall.domain.Schedule;
import oncall.domain.StartDay;

public class OncallService {

    public void assign(StartDay startDay, Employees weekdayEmployees, Employees weekendEmployees) {
        int month = startDay.getMonth(); // 5
        int endDate = Calendar.getEndDateOf(month); // 31

        List<String> days = Day.getDays(startDay.getDay(), endDate); // 1~31

        List<Schedule> schedules = new ArrayList<>();
        for (int i = 1; i < endDate + 1; i++) {
            boolean isRestDay = isRestDay(month, i, days.get(i - 1)); // 5, 1~31, 목,금,,
            schedules.add(new Schedule(i, days.get(i - 1), isRestDay)); // 1~31, 목,금,, t/f
        }

        setSchedules(schedules, weekdayEmployees, weekendEmployees);
    }

    private void setSchedules(List<Schedule> schedules,
                              Employees weekdayEmployees, Employees weekendEmployees) {
        schedules.forEach(schedule -> {
            if (!schedule.isRestDay()) {
                schedule.addEmployee(weekdayEmployees.popEmploy());
            } else {
                schedule.addEmployee(weekendEmployees.popEmploy());
            }
        });
    }

    private boolean isRestDay(int month, int day, String date) {
        if (Day.isWeekend(date)) {
            return true;
        }
        return LegalHolidays.isIn(month, day);
    }
}
