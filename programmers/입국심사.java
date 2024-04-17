import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long answer = Long.MAX_VALUE;
        long left = times[0];
        long right = (long) times[times.length-1] * (long) n;
        long mid = 0;
        long cnt = 0;
        
        while (left <= right) {
            mid = (left + right) / 2;
            cnt = 0;
            
            for (int time : times) {
                cnt += mid / time;
            }
            
            if (cnt >= n) {
                answer = mid;
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return answer;
    }
}
