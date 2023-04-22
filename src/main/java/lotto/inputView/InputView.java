package lotto.inputView;

import camp.nextstep.edu.missionutils.Console;
import lotto.validate.InputViewValidation;

public class InputView {

    private InputViewValidation inputViewValidation = new InputViewValidation();

    public String inputLottoMoney(){
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        inputViewValidation.checkInputMoney(input);
        return input;
    }
}
