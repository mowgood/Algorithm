import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        int[] R = new int[N];
        int[] G = new int[N];
        int[] B = new int[N];
        
        StringTokenizer st;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            R[i] = Integer.parseInt(st.nextToken());
            G[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N][3];
        dp[0][0] = R[0];
        dp[0][1] = G[0];
        dp[0][2] = B[0];

        for(int i=1; i<N; i++) {
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + R[i];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + G[i];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + B[i];
        }

        int answer = dp[N-1][0];
        for(int i=1; i<=2; i++) {
            if(answer > dp[N-1][i]) answer = dp[N-1][i];
        }

        System.out.println(answer);
       
    }
}
