import java.util.stream.Stream;

class Solution {
    public int solution(String num_str) {
        // return num_str.chars()
        //     .map(Character::getNumericValue)
        //     .sum();
        
        return Stream.of(num_str.split(""))
            .mapToInt(Integer::parseInt)
            .sum();
    }
}
