import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] map;
    static int[][] dp;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {   
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dp = new int[N][N];

        StringTokenizer st;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                int cnt = dfs(i, j);
                answer = Math.max(answer, cnt);
            }
        }

        System.out.println(answer); 
    } 

    public static int dfs(int y, int x) {
        // 이전에 방문했다면 해당 값 리턴
        if(dp[y][x] != 0) return dp[y][x];
        else {
            // 현재 칸의 방문 횟수는 1
            dp[y][x] = 1;

            for(int i=0; i<4; i++) {
                int nextY = y + dy[i];
                int nextX = x + dx[i];

                if(nextY < 0 || nextY >= N || nextX < 0 || nextX >= N) continue;
                
                // 대나무가 더 많은 지역으로 이동
                if(map[nextY][nextX] > map[y][x]) {
                    // 현재 방문 값과 다음 위치 방문 값 중 더 큰 값을 저장해 최대값을 구한다
                    dp[y][x] = Math.max(dp[y][x], dfs(nextY, nextX)+1);
                }
            }
        }
        return dp[y][x];
    }
}
