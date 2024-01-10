import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {   
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[] dp = new int[N+2];

        int[][]work = new int[N+1][2]; // 기간, 금액
        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            work[i][0] = Integer.parseInt(st.nextToken());
            work[i][1] = Integer.parseInt(st.nextToken());
        }
        
        for(int i=N; i>0; i--) {
            int end = i + work[i][0];
            if(end > N+1) {
                dp[i] = dp[i+1];
            } else {
                dp[i] = Math.max(dp[i+1], dp[end] + work[i][1]);
            }
        }
        
        System.out.println(dp[1]);
    }
}
