import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        return Arrays.stream(numbers)
            .boxed()
            .sorted((a, b) ->  b - a)
            .limit(2)
            .mapToInt(Integer::intValue)
            .reduce(1, (x, y) -> x * y);
    }
}
