package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.validate.InputViewValidation;

public class InputView {

    public static String inputLottoMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        InputViewValidation.checkInputMoney(input);
        return input;
    }

    public static List<Integer> inputLottoAnswer() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        InputViewValidation.checkLottoAnswer(input);
        return Arrays.stream(input.split(",")).map(num -> Integer.parseInt(num))
            .collect(Collectors.toList());
    }

    public static int inputLottoBonus(List<Integer> lottoAnswer) {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요");
        String input = Console.readLine();
        InputViewValidation.checkLottoBonus(input, lottoAnswer);
        return Integer.parseInt(input);
    }
}
