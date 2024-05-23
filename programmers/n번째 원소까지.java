import java.util.stream.IntStream;
// import java.util.*;

class Solution {
    public int[] solution(int[] num_list, int n) {
        // 1
        return IntStream.range(0, n)
            .map(i -> num_list[i])
            .toArray();
        
        // 2
        // return Arrays.copyOfRange(num_list, 0, n);
    }
}
