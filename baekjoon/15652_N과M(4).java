import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        dfs(1, 0);

        System.out.println(sb);
    }

    static void dfs(int current, int cnt) {
        if(cnt == M) {
            for(int i : arr) {
                sb.append(i + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i=current; i<=N; i++) {
            arr[cnt] = i;
            dfs(i, cnt+1);
        }
        return;  
    }
}
