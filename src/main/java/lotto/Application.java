package lotto;

import java.util.HashMap;
import java.util.Map;
import lotto.controller.LottoController;

public class Application {

    public static void main(String[] args) {
        LottoController lottoController = new LottoController();
        lottoController.run();
    }
}
