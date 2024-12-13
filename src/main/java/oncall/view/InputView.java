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


}
