import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] dp; // 해당 지점까지의 얼리어답터 인원수 (자식 노드들의 dp 개수를 더한다)
    static boolean[] visited;
    static Node[] tree;
    public static void main(String[] args) throws IOException {   
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N+1][2]; // [노드번호][0:얼리어답터아님, 1:얼리어답터임]
        visited = new boolean[N+1];
        tree = new Node[N+1];
        StringTokenizer st;
        for(int i=1; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            tree[start] = new Node(end, tree[start]);
            tree[end] = new Node(start, tree[end]);
        }

        dfs(1); // 트리 구조이기 때문에 1부터 시작
        System.out.println(Math.min(dp[1][0], dp[1][1]));
        
    } 
    
    static void dfs(int number) {
        visited[number] = true;
        dp[number][0] = 0;
        dp[number][1] = 1;

        for(Node next = tree[number]; next != null; next=next.next) {
            if(!visited[next.n]) {
                dfs(next.n); // 재귀를 통해 자식 노드의 dp값을 미리 구한다
                dp[number][0] += dp[next.n][1]; // 자식 노드가 무조건 얼리어답터야 함
                dp[number][1] += Math.min(dp[next.n][0], dp[next.n][1]); // 최소 얼리어답터 인원을 구해야 함
            }
        }
    }
}

class Node {
    int n;
    Node next;

    public Node(int n, Node next) {
        this.n = n;
        this.next = next;
    }
}
