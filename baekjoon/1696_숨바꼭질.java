import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] dist = new int[100002];
        Arrays.fill(dist, -1);

        Queue<Integer> q = new LinkedList<>();
        q.offer(N);
        dist[N] = 0;

        while(dist[K] == -1) {
            int now = q.poll();
            int[] move = {now-1, now+1, 2*now};

            for(int next : move) {
                if(next < 0 || next > 100000) continue;
                if(dist[next] != -1) continue;
                
                dist[next] = dist[now] + 1;
                q.offer(next);
            }
        } 
        System.out.println(dist[K]);
    }
}
