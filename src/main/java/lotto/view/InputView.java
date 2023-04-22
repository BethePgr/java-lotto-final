package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validate.InputViewValidation;

public class InputView {

    public static String inputLottoMoney(){
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        InputViewValidation.checkInputMoney(input);
        return input;
    }
}
