package lotto.domain;

public enum LottoRank {
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
    Three(5000,3,false),
    Four(50000,4,false),
    Five(1500000,5,false),
    FiveAndBonus(30000000,5,true),
    Six(2000000000,6,false);

    private final int price;
    private final int correctCount;
    private final boolean correctBonus;

    LottoRank(int price, int correctCount, boolean correctBonus){
        this.price = price;
        this.correctCount = correctCount;
        this.correctBonus = correctBonus;
    }

    public int getPrice(){
        return price;
    }

    public int getCorrectCount(){
        return correctCount;
    }
}
