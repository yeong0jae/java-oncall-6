package oncall;

import java.util.List;
import oncall.domain.Calendar;
import oncall.domain.Day;
import oncall.domain.Employees;
import oncall.domain.StartDay;

public class OncallService {

    public void assign(StartDay startDay, Employees weekdayEmployees, Employees weekendEmployees) {
        int startMonth = startDay.getMonth();
        int endDate = Calendar.getEndDateOf(startMonth);

        List<String> days = Day.getDays(startDay.getDay(), endDate);
    }
}
