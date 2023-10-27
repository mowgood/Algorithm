import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        dfs(1, 0);
    }

    private static void dfs(int current, int cnt) {
        if(cnt == M) {
            for(int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for(int i=current; i<=N; i++) {
            arr[cnt] = i;
            dfs(i+1, cnt+1);
        }
        return;
    }
}
