package lotto.controller;

import java.util.List;
import lotto.domain.LottoResult;
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

        List<Integer> lottoAnswer = InputView.inputLottoAnswer();
        int lottoBonus = InputView.inputLottoBonus(lottoAnswer);
        LottoResult lottoResult = new LottoResult(lottoTickets, lottoAnswer, lottoBonus);
        OutputView.printLottoResults(lottoResult);
        OutputView.printBenefit(Integer.parseInt(money),lottoResult);
    }

}
