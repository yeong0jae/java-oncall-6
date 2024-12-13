package oncall.controller;

import java.util.List;
import java.util.function.Supplier;
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
        StartDay startDay = retryUntilValid(() -> {
            List<String> inputStartDay = inputView.readStartDay();
            return new StartDay(inputStartDay);
        });

        Employees weekdayEmployees = getWeekdayEmployees();
        Employees weekendEmployees = getWeekendEmployees();

        List<Schedule> schedules = oncallService.assign(startDay, weekdayEmployees, weekendEmployees);
        outputView.printSchedules(startDay.getMonth(), schedules);
    }

    private Employees getWeekendEmployees() {
        return retryUntilValid(() -> {
            List<String> inputWeekendEmployees = inputView.readWeekendEmployees();
            return new Employees(inputWeekendEmployees);
        });
    }

    private Employees getWeekdayEmployees() {
        return retryUntilValid(() -> {
            List<String> inputWeekdayEmployees = inputView.readWeekdayEmployees();
            return new Employees(inputWeekdayEmployees);
        });
    }

    private static <T> T retryUntilValid(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
