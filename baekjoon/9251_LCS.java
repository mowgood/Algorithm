import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {   
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] str1 = br.readLine().split("");
        String[] str2 = br.readLine().split("");
        int[][] dp = new int[str1.length+1][str2.length+1];

        for(int i=1; i<=str1.length; i++) {
            for(int j=1; j<=str2.length; j++) {
                if(str1[i-1].equals(str2[j-1])) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        int max = 0;
        for(int i=0; i<dp.length; i++) {
            for(int  j=0; j<dp[0].length; j++) {
                if(max < dp[i][j]) max = dp[i][j];
            }
        }
        System.out.println(max);

        // int curX = dp.length-1;
        // int curY = dp[0].length-1;

        // while(true) {
        //     if(curX < 1 || curY < 1) break;

        //     // 공통 문자열 추가
        //     if(str1[curX-1].equals(str2[curY-1])) {
        //             sb.append(str1[curX-1]);
        //     }

        //     if(dp[curX][curY] == dp[curX-1][curY]) {
        //         curX--;
        //     } else if(dp[curX][curY] == dp[curX][curY-1]) {
        //         curY--;
        //     } else {
        //         curX--;
        //         curY--;               
        //     }
        // }
        // System.out.println(sb.reverse());    
    } 
}
