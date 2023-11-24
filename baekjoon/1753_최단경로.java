import java.util.*;
import java.io.*;

public class Main {
    static class Node implements Comparable<Node> {
        int end, weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        public int compareTo(Node n) {
            return weight - n.weight;
        }
    }

    static int[] dist;
    static List<Node> list[];
    static boolean[] visit;
    public static void main(String[] args) throws IOException {   
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V, E, K, u, v, w;
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        dist = new int[V+1];
        list = new ArrayList[V+1];
        visit = new boolean[V+1];

        Arrays.fill(dist, -1);

        for(int i=1; i<=V; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            list[u].add(new Node(v, w));
        }

        dijkstra(K);

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=V; i++) {
            if(dist[i] == -1) sb.append("INF\n");
            else sb.append(dist[i] + "\n");
        }

        System.out.println(sb);
    } 

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Node now;

        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()) {
            now = pq.poll();

            if(visit[now.end]) continue;
            visit[now.end] = true;
            for(Node next : list[now.end]) {
                if(dist[next.end] == -1 || dist[next.end] > dist[now.end] + next.weight) {
                    dist[next.end] = dist[now.end] + next.weight;
                    pq.offer(new Node(next.end, dist[next.end]));
                }
            }
        }
    }
}
