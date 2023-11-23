import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {   
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int[] dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<N; i++) {
            dp[i] = 1;

            // i 이전 원소들 조회
            for(int j=0; j<i; j++) {
                // 이전 원소가 현재 원소보다 작으면서 dp[i]가 dp[j]+1보다 작은 경우
                if(arr[j] < arr[i] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int max = -1;
        for(int i=0; i<N; i++) {
            if(dp[i] > max) max = dp[i];
        }

        System.out.println(max);      
    } 
}
