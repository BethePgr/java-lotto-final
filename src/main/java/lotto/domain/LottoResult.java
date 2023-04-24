package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LottoResult {

    private final LottoTickets lottoTickets;
    private final List<Integer> lottoAnswer;
    private final int bonusNumber;
    private final Map<LottoRank,Integer> map = new EnumMap<LottoRank, Integer>(LottoRank.class);

    public LottoResult(LottoTickets lottoTickets, List<Integer> lottoAnswer, int bonusNumber) {
        this.lottoTickets = lottoTickets;
        this.lottoAnswer = lottoAnswer;
        this.bonusNumber = bonusNumber;
        initMap();
        createMap();
    }

    public void initMap(){
        List<LottoRank> lottoranks = Arrays.stream(LottoRank.values()).collect(Collectors.toList());
        for(LottoRank lottoRank: lottoranks){
            map.put(lottoRank,0);
        }
    }


    public void createMap() {
        for (Lotto lottoTicket : lottoTickets.getLottoTickets()) {
            List<Integer> numbers = lottoTicket.getNumbers();
            LottoRank lottoRank = getLottoRank(numbers, lottoAnswer, bonusNumber);
            map.put(lottoRank, map.get(lottoRank)+1);
        }
    }

    private LottoRank getLottoRank(List<Integer> numbers, List<Integer> lottoAnswer,
        int bonusNumber) {
        int count = (int) numbers.stream()
            .filter(num -> lottoAnswer.stream().anyMatch(Predicate.isEqual(num))).count();
        boolean bonus = lottoAnswer.contains(bonusNumber);
        return Arrays.stream(LottoRank.values())
            .filter(num -> LottoRank.checkLottoRank(num, count, bonus)).findAny()
            .orElse(LottoRank.None);
    }

    public Map<LottoRank,Integer> getMap(){
        return map;
    }
}
