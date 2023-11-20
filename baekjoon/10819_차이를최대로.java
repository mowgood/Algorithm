import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] arr, arr2;
    static int answer = 0;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {   
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        arr2 = new int[N];
        visit = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());    
        }

        dfs(0);

        System.out.println(answer);

    } 

    public static void dfs(int depth) {
        if(depth == N) {
            int sum = 0;
            for(int i=0; i<N-1; i++) {
                sum += Math.abs(arr2[i] - arr2[i+1]);
            }
            answer = Math.max(answer, sum);
            return;
        }

        for(int i=0; i<N; i++) {
            if(visit[i]) continue;
            arr2[depth] = arr[i];
            visit[i] = true;
            dfs(depth+1);
            visit[i] = false;
        }
    }
}
