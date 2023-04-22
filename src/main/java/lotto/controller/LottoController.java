package lotto.controller;

import lotto.domain.LottoTickets;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void run(){
        String money = InputView.inputLottoMoney();
        OutputView.printLottoCount(money);

        int lottoCount = Integer.parseInt(money) / 1000;
        LottoTickets lottoTickets = new LottoTickets(lottoCount);
        OutputView.printLottoTickets(lottoTickets);

        InputView.inputLottoAnswer();
    }

    public static void main(String[] args) {
        LottoController lc = new LottoController();
        lc.run();
    }
}
