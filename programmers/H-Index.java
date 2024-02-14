import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
        for (int i = citations.length-1; i >= 1; i--) {
            if (citations[citations.length-i-1] >= i+1) {
                answer = i+1;
                break;
            }
        }
        
        return answer;
    }
}
