import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        Deque<Integer> dq = new ArrayDeque<>();
        
        for (int weight : people) {
            dq.offer(weight);
        }
        
        while(!dq.isEmpty()) {
            if (dq.peekFirst() + dq.peekLast() <= limit) {
                dq.pollFirst();
                dq.pollLast();
            }
            else {
                dq.pollLast();
            }
            answer++;
        }
        return answer;
    }
}
