import java.util.stream.IntStream;

class Solution {
    public int solution(int n) {
        // 1
        // int answer = 0;
        // for (int i = 2; i <= n; i += 2) {
        //     answer += i;
        // }
        // return answer;
        
        // 2
        return IntStream.rangeClosed(2, n).filter(i -> i % 2 == 0).sum();
    }
}
