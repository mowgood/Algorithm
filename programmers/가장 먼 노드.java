import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        List<ArrayList<Integer>> list = new ArrayList<>();
        int[] distance = new int[n+1];
        boolean[] visit = new boolean[n+1];
        
        for (int i = 0; i < n + 1; i++) {
            list.add(new ArrayList<>());
        }
        
        for (int i = 0; i < edge.length; i++) {
            list.get(edge[i][0]).add(edge[i][1]);
            list.get(edge[i][1]).add(edge[i][0]);
        }
        
        Queue<Integer> nodes = new LinkedList<>();
        nodes.offer(1);
        visit[1] = true;
        
        while(!nodes.isEmpty()) {
            int now = nodes.poll();
            List<Integer> next_nodes = list.get(now);
            for (int next : next_nodes) {
                if (visit[next]) continue;
                nodes.offer(next);
                visit[next] = true;
                distance[next] = distance[now] + 1;
            }
        }
        
        Arrays.sort(distance);
        int max = distance[distance.length-1];
        for (int i = distance.length-1; distance[i] == max; i--) {
            answer++;
        }
        
        return answer;
    }
}
