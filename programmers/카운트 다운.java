import java.util.stream.*;

class Solution {
    public int[] solution(int start, int end_num) {
        return IntStream.rangeClosed(end_num, start)
                .map(i -> (start + end_num) - i)
                .toArray();
    }
}
