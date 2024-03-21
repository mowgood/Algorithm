import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        StringTokenizer st;
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> (o2 - o1));
        
        for (String op : operations) {
            st = new StringTokenizer(op);
            String cmd = st.nextToken();
            int num = Integer.parseInt(st.nextToken());

            if (cmd.equals("I")) {
                minHeap.offer(num);
                maxHeap.offer(num);
                continue;
            }
            
            // 큐가 비었으면 삭제 연산 무시
            if (minHeap.isEmpty()) continue;
            
            if (num >= 0) {
                // 최댓값 삭제
                int max = maxHeap.poll();
                minHeap.remove(max);
            }
            else {
                // 최솟값 삭제
                int min = minHeap.poll();
                maxHeap.remove(min);
            }
        }
        
        if (minHeap.isEmpty()) return new int[] {0, 0};
        
        answer[0] = maxHeap.peek();
        answer[1] = minHeap.peek();
        
        return answer;
    }
}
