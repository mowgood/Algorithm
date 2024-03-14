import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] numbers, int num1, int num2) {
        // return Arrays.copyOfRange(numbers, num1, num2+1);
        
        return IntStream.rangeClosed(num1, num2)
            .map(i -> numbers[i])
            .toArray();
    }
}
