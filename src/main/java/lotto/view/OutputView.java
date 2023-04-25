package lotto.view;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;
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
/*
당첨 통계
---
3개 일치 (5,000원) - 1개
4개 일치 (50,000원) - 0개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
6개 일치 (2,000,000,000원) - 0개
총 수익률은 62.5%입니다.
 */
    public static void printLottoResults(LottoResult lottoResult){
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        DecimalFormat formats = new DecimalFormat("###,###");
        List<Entry<LottoRank, Integer>> lottoResults = createLottoResults(lottoResult);
        for(Entry<LottoRank,Integer> entry : lottoResults){
            String temp="";
            if(entry.getKey().isCorrectBonus()){
                temp=", 보너스 볼 일치";
            }
            System.out.println(entry.getKey().getCorrectCount()+"개 일치"+temp+ " ("+formats.format(entry.getKey().getPrice())+"원) - " + entry.getValue()+"개");
        }
    }

    private static List<Entry<LottoRank, Integer>> createLottoResults(LottoResult lottoResult){
        return lottoResult.getMap().entrySet().stream().filter(entry -> !entry.getKey().equals(LottoRank.None)).collect(
            Collectors.toList());
    }

    public static void printBenefit(int money,LottoResult lottoResult){
        System.out.printf("총 수익률은 %.1f%%입니다.",calculateBenefit(money,lottoResult));
    }

    private static double calculateBenefit(int money,LottoResult lottoResult){
        long benefit = 0;
        List<Entry<LottoRank, Integer>> lottoResults = createLottoResults(lottoResult);
        for(Entry<LottoRank,Integer> entry : lottoResults){
            benefit += (long)entry.getKey().getPrice() * entry.getValue();
        }
        return (double)benefit*100/money;
    }
}
