import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        // 풀이 2
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int p : priorities) {
            pq.add(p);
        }
        
        while(!pq.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (priorities[i] == pq.peek()) {
                    pq.poll();
                    answer++;
                    if (i == location) {
                        return answer;
                    }
                }
            }
        }
        
        return answer;
        
        // 풀이 1
//         Queue<Integer> q = new LinkedList<>();
//         Queue<Integer> q2 = new LinkedList<>();
//         for (int i = 0; i < priorities.length; i++) {
//             q.add(priorities[i]);
//             q2.add(i);
//         }
        
//         while(!q.isEmpty()) {
//             boolean isRun = true;
//             int now = q.poll();
//             int now2 = q2.poll();
//             for (Integer num : q) {
//                 if (now < num) {
//                     q.add(now);
//                     q2.add(now2);
//                     isRun = false;
//                     break;
//                 }
//             }
//             if (isRun) {
//                 answer++;
//             }
//             if (isRun && now2 == location) {
//                 break;
//             }
//         }
//         return answer;
    }
}
