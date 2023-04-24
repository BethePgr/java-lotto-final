package lotto.domain;

public enum LottoRank {

    Three(5000,3,false),
    Four(50000,4,false),
    Five(1500000,5,false),
    FiveAndBonus(30000000,5,true),
    Six(2000000000,6,false),
    None(0,0,false);
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
