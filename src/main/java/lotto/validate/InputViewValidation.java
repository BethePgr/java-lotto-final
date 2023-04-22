package lotto.validate;

import java.util.Arrays;
import java.util.stream.Stream;

public class InputViewValidation {

    public static void checkInputMoney(String input){
        if(onlyNumber(input)){
            if(divide1000(input) && notStartWith0(input)){
                return;
            }
        }
        throw new IllegalArgumentException("[ERROR] 1000으로 나누어 떨어지는 숫자만을 입력하시오.");
    }

    private static boolean onlyNumber(String input){
        return input.chars().allMatch(num -> num-'0'>=0 && num -'0'<=9);
    }

    private static boolean divide1000(String input){
        return Integer.parseInt(input) % 1000 == 0;
    }

    private static boolean notStartWith0(String input){
        return input.charAt(0) != '0';
    }

    public static void checkLottoAnswer(String input) {
        if(onlyNumberPlusComma(input)) {
            if (checkBetween1And45(input) && checkStringWithDistinctSixNum(input)
                && checkStringWithSixNum(input)) {
                return;
            }
        }
        throw new IllegalArgumentException("[ERROR] 1과 45사이의 6개의 숫자를 사이사이에 컴마를 추가해서 입력해야한다.");
    }

    private static boolean checkStringWithDistinctSixNum(String input){
        return Arrays.stream(input.split(",")).distinct().count() == 6;
    }

    private static boolean checkStringWithSixNum(String input){
        return Arrays.stream(input.split(",")).count() == 6;
    }

    private static boolean checkBetween1And45(String input){
        return Arrays.stream(input.split(",")).allMatch(num -> Integer.parseInt(num) >= 1 && Integer.parseInt(num) <=45);
    }

    private static boolean onlyNumberPlusComma(String input){
        String reg = "^[0-9]*$";
        return Arrays.stream(input.split(",")).allMatch(num -> num.matches(reg));
    }

    public static void checkLottoBonus(String input,String lottoAnswer){
        if(onlyNumber(input)){
            if(checkOneBetween1And45(input) && checkLottoAnswerNotContainsString(input,lottoAnswer)){
                return;
            }
        }
        throw new IllegalArgumentException("[ERROR] 1과 45사이의 숫자이면서 로또 당첨 번호에 없는 숫자여야합니다.");
    }

    private static boolean checkOneBetween1And45(String input){
        return Integer.parseInt(input) >= 1 && Integer.parseInt(input) <= 45;
    }

    private static boolean checkLottoAnswerNotContainsString(String input,String lottoAnswer){
        String[] split = lottoAnswer.split(",");
        return Arrays.stream(split).noneMatch(num -> num.equals(input));
    }
}
