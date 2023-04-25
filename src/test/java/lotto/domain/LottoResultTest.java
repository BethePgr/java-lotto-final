package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {

    @Test
    void 두개의_맵은_동일해야한다() throws Exception {
        List<Integer> list = new ArrayList<>(List.of(2,3,4,5,6,7));
        LottoResult lottoResult = new LottoResult(new LottoTickets(0),list,1);
        lottoResult.getMap().put(LottoRank.Three,2);
        lottoResult.getMap().put(LottoRank.Five,5);
        lottoResult.getMap().put(LottoRank.FiveAndBonus,6);
        lottoResult.getMap().put(LottoRank.Six,1);
        Map<LottoRank,Integer> map = new EnumMap<LottoRank, Integer>(LottoRank.class);
        map.put(LottoRank.Three,2);
        map.put(LottoRank.Five,5);
        map.put(LottoRank.FiveAndBonus,6);
        map.put(LottoRank.Six,1);
        map.put(LottoRank.Four,0);
        map.put(LottoRank.None,0);

        assertEquals(map,lottoResult.getMap());
    }

}