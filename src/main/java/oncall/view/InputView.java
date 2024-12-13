package oncall.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

    public List<String> readStartDay() {
        System.out.print("비상 근무를 배정할 월과 시작 요일을 입력하세요> ");
        String[] input = Console.readLine().split(",");
        return Arrays.stream(input).toList();
    }

    public List<String> readWeekdayEmployees() {
        System.out.print("평일 비상 근무 순번대로 사원 닉네임을 입력하세요> ");
        String[] input = Console.readLine().split(",");
        return Arrays.stream(input).toList();
    }

    public List<String> readWeekendEmployees() {
        System.out.print("휴일 비상 근무 순번대로 사원 닉네임을 입력하세요> ");
        String[] input = Console.readLine().split(",");
        return Arrays.stream(input).toList();
    }

}
