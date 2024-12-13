package oncall.controller;

import static oncall.controller.RetryController.retryUntilValid;

import java.util.List;
import oncall.OncallService;
import oncall.domain.Employees;
import oncall.domain.Schedule;
import oncall.domain.StartDay;
import oncall.view.InputView;
import oncall.view.OutputView;

public class OncallController {

    private final InputView inputView;
    private final OutputView outputView;
    private final OncallService oncallService = new OncallService();

    public OncallController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        StartDay startDay = getStartDay();

        Employees weekdayEmployees;
        Employees weekendEmployees;
        while (true) {
            try {
                weekdayEmployees = getWeekdayEmployees();
                weekendEmployees = getWeekendEmployees();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        List<Schedule> schedules = oncallService.assign(startDay, weekdayEmployees, weekendEmployees);
        outputView.printSchedules(startDay.getMonth(), schedules);
    }

    private StartDay getStartDay() {
        return retryUntilValid(() -> {
            List<String> inputStartDay = inputView.readStartDay();
            return new StartDay(inputStartDay);
        });
    }

    private Employees getWeekendEmployees() {
        List<String> inputWeekendEmployees = inputView.readWeekendEmployees();
        return new Employees(inputWeekendEmployees);
    }

    private Employees getWeekdayEmployees() {
        List<String> inputWeekdayEmployees = inputView.readWeekdayEmployees();
        return new Employees(inputWeekdayEmployees);
    }

}
