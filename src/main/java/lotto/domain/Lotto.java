package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers){
        if(validateSize(numbers) && validateDistinctSize(numbers)){
            return;
        }
        throw new IllegalArgumentException("[ERROR] 중복되지 않은 6개의 숫자들만 하나의 로또가 될 수 있습니다.");
    }

    private boolean validateSize(List<Integer> numbers) {
        return numbers.size() == 6;
    }

    // TODO: 추가 기능 구현
    private boolean validateDistinctSize(List<Integer> numbers){
        return numbers.stream().distinct().count() == 6;
    }

    public List<Integer> getNumbers(){
        return numbers;
    }
}
