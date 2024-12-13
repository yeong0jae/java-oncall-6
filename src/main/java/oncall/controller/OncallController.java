package oncall.controller;

import java.util.List;
import java.util.function.Supplier;
import oncall.domain.Employees;
import oncall.domain.StartDay;
import oncall.view.InputView;
import oncall.view.OutputView;

public class OncallController {

    private final InputView inputView;
    private final OutputView outputView;

    public OncallController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        StartDay startDay = retryUntilValid(() -> {
            List<String> inputStartDay = inputView.readStartDay();
            return new StartDay(inputStartDay);
        });

        List<String> inputWeekdayEmployees = inputView.readWeekdayEmployees();
        Employees weekdayEmployees = new Employees(inputWeekdayEmployees);

        List<String> inputWeekendEmployees = inputView.readWeekendEmployees();
        Employees weekendEmployees = new Employees(inputWeekendEmployees);

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
