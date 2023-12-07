import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {   
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] indegree = new int[N+1];
        int[] time = new int[N+1];
        List<List<Integer>> list = new ArrayList<>();

        for(int i=0; i<=N; i++) {
            list.add(new ArrayList<>());
        }

        StringTokenizer st;
        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            while(true) {
                int preTemp = Integer.parseInt(st.nextToken());
                if (preTemp == -1)
                    break;
                list.get(preTemp).add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=N; i++) {
            if(indegree[i] == 0) 
                queue.offer(i);           
        }

        int[] result = new int[N+1];
        while(!queue.isEmpty()) {
            int now = queue.poll();

            for(int next : list.get(now)) {
                indegree[next]--;
                result[next] = Math.max(result[next], result[now] + time[now]);
                if(indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        
        for(int i=1; i<=N; i++) {
            sb.append(result[i] + time[i] + "\n");
        }

        System.out.println(sb);
    }
}
