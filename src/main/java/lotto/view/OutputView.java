package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoTickets;

public class OutputView {

    public static void printLottoCount(String input){
        System.out.println();
        int lottoCount = Integer.parseInt(input) / 1000;
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public static void printLottoTickets(LottoTickets lottoTickets){
        for(Lotto lotto : lottoTickets.getLottoTickets()){
            System.out.println(lotto.getNumbers());
        }
    }

}
