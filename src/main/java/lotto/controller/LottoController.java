package lotto.controller;

import lotto.domain.LottoTickets;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void run(){
        try{
            runNoTC();
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    private void runNoTC(){
        String money = InputView.inputLottoMoney();
        OutputView.printLottoCount(money);

        int lottoCount = Integer.parseInt(money) / 1000;
        LottoTickets lottoTickets = new LottoTickets(lottoCount);
        OutputView.printLottoTickets(lottoTickets);

        String lottoAnswer = InputView.inputLottoAnswer();
        InputView.inputLottoBonus(lottoAnswer);
    }

}
