// import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        // 풀이 1
        int answer = 45;
        
        for (int number : numbers) {
            answer -= number;
        }
        
        return answer;
        
        // 풀이 2
        // return 45-Arrays.stream(numbers).sum();
    }
}
