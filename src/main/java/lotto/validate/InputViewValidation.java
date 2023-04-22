package lotto.validate;

public class InputViewValidation {

    public void checkInputMoney(String input){
        if(onlyNumber(input)){
            if(divide1000(input) && notStartWith0(input)){
                return;
            }
        }
        throw new IllegalArgumentException("[ERROR] 1000으로 나누어 떨어지는 숫자만을 입력하시오.");
    }

    private boolean onlyNumber(String input){
        return input.chars().allMatch(num -> num-'0'>=0 && num -'0'<=9);
    }

    private boolean divide1000(String input){
        return Integer.parseInt(input) % 1000 == 0;
    }

    private boolean notStartWith0(String input){
        return input.charAt(0) != '0';
    }
}
