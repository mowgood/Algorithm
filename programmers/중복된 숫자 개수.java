// import java.util.*;

class Solution {
    public int solution(int[] array, int n) {
        int answer = 0;
        for (int i : array) {
            if (i == n) answer++;
        }
      
        // long cnt = Arrays.stream(array).filter(i -> i == n).count();
        // int cnt2 = (int) Arrays.stream(array).filter(i ->i == n).count();
      
        return answer;  
    }
}
