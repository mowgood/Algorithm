import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int work : works) {
            pq.offer(work);
        }
        
        int remain = 0;
        for (int i = 0; i < n; i++) {
            if (pq.isEmpty()) break;
            remain = pq.poll() - 1;
            if (remain >= 1) pq.offer(remain);
        }
        
        for(Integer work : pq) {
            answer += Math.pow(work, 2);
        }
        
        return answer;
    }
}
