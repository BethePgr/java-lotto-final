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

    public LottoResult(LottoTickets lottoTickets, List<Integer> lottoAnswer, int bonusNumber) {
        this.lottoTickets = lottoTickets;
        this.lottoAnswer = lottoAnswer;
        this.bonusNumber = bonusNumber;
    }

    public void createMap(LottoTickets lottoTickets, List<Integer> lottoAnswer, int bonusNumber) {
        Map<LottoRank, Integer> map = new EnumMap<>(LottoRank.class);

        for (Lotto lottoTicket : lottoTickets.getLottoTickets()) {
            List<Integer> numbers = lottoTicket.getNumbers();
            int count = (int) numbers.stream()
                .filter(num -> lottoAnswer.stream().anyMatch(Predicate.isEqual(num))).count();
            boolean bonus = lottoAnswer.contains(bonusNumber);
            LottoRank lottoRank = Arrays.stream(LottoRank.values())
                .filter(num -> LottoRank.checkLottoRank(num, count, bonus)).findAny()
                .orElse(LottoRank.None);

        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(LottoRank.values()));
        boolean flag = true;
        LottoRank lottoRank = Arrays.stream(LottoRank.values())
            .filter(num -> LottoRank.checkLottoRank(num, 5, flag)).findAny()
            .orElse(LottoRank.None);
        LottoRank lottoRank2 = Arrays.stream(LottoRank.values())
            .filter(num -> LottoRank.checkLottoRank(num, 5, !flag)).findAny()
            .orElse(LottoRank.None);
        System.out.println(lottoRank);
        System.out.println(lottoRank2);
    }
}
