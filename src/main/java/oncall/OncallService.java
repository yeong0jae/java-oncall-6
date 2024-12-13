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

    public List<Schedule> assign(StartDay startDay, Employees weekdayEmployees, Employees weekendEmployees) {
        int month = startDay.getMonth(); // 5
        int endDate = Calendar.getEndDateOf(month); // 31
        List<String> days = Day.getDays(startDay.getDay(), endDate); // 1~31

        List<Schedule> schedules = new ArrayList<>();
        for (int i = 1; i < endDate + 1; i++) {
            boolean isRestDay = isRestDay(month, i, days.get(i - 1)); // 5, 1~31, 목,금,,
            schedules.add(new Schedule(i, days.get(i - 1), isRestDay)); // 1~31, 목,금,, t/f
        }
        return setSchedules(schedules, weekdayEmployees, weekendEmployees);
    }

    private List<Schedule> setSchedules(List<Schedule> schedules,
                                        Employees weekdayEmployees, Employees weekendEmployees) {
        for (int i = 0; i < schedules.size(); i++) {
            Schedule schedule = schedules.get(i);
            String preEmployeeName = getPreEmployeeName(schedules, i);
            assignEmployee(weekdayEmployees, weekendEmployees, schedule, preEmployeeName);
        }
        return schedules;
    }
    
    private static void assignEmployee(Employees weekdayEmployees, Employees weekendEmployees, Schedule schedule,
                                       String preEmployeeName) {
        if (!schedule.isRestDay()) {
            if (preEmployeeName.equals(weekdayEmployees.getNameFirst())) {
                weekdayEmployees.shuffle();
            }
            schedule.addEmployee(weekdayEmployees.popEmploy());
        } else {
            if (preEmployeeName.equals(weekendEmployees.getNameFirst())) {
                weekendEmployees.shuffle();
            }
            schedule.addEmployee(weekendEmployees.popEmploy());
        }
    }

    private static String getPreEmployeeName(List<Schedule> schedules, int i) {
        String preEmployeeName;
        if (i == 0) {
            preEmployeeName = "";
        } else {
            preEmployeeName = schedules.get(i - 1).getName();
        }
        return preEmployeeName;
    }

    private boolean isRestDay(int month, int day, String date) {
        if (Day.isWeekend(date)) {
            return true;
        }
        return LegalHolidays.isIn(month, day);
    }
}
