import java.util.*;

class Solution {
    public int solution(int[][] jobs) {     
        // 요청 시점 오름차순 정렬
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        
        // 소요 시간 오름차순 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        
        int cnt = 0;
        int idx = 0;
        int end = 0;
        int time = 0;
        while (cnt < jobs.length) {
            while (idx < jobs.length && jobs[idx][0] <= end) {
                pq.offer(jobs[idx++]);
            }
            
            if (pq.isEmpty()) {
                end = jobs[idx][0];
            }
            else {
                int[] job = pq.poll();
                time += job[1] + end - job[0];
                end += job[1];
                cnt++;
            }
        }
        
        return time / jobs.length;
    }
}
