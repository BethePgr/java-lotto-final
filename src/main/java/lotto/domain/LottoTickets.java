package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTickets {

    private List<Lotto> lottoTickets;

    public LottoTickets(int lottoMoney) {
        makeLottoTickets(lottoMoney);
    }

    public void makeLottoTickets(int lottoMoney) {
        List<Lotto> tempLottoTickets = new ArrayList<>();
        for (int i = 0; i < lottoMoney; i++) {
            tempLottoTickets.add(makeOneLotto());
        }
        lottoTickets = tempLottoTickets;
    }

    private Lotto makeOneLotto(){
        List<Integer> tempLotto = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(tempLotto);
        return new Lotto(tempLotto);
    }

    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }
}
