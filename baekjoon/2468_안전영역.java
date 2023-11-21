import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] visit;
    static int cnt = 0;
    static int answer = 1;
    public static void main(String[] args) throws IOException {   
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visit = new boolean[N][N];

        StringTokenizer st;
        Set<Integer> hight = new HashSet<>();
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                int current = Integer.parseInt(st.nextToken());
                hight.add(current);
                map[i][j] = current;
            }
        }

        for(Integer i : hight) {
            // 높이가 i일 때 공간은 몇개?
            cnt = 0;
            visit = new boolean[N][N];
            getCnt(i);
            answer = Math.max(answer, cnt);
        }

        System.out.println(answer);

    } 

    public static void getCnt(int hight) {
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(visit[i][j] || map[i][j] <= hight) continue;
                visit[i][j] = true;
                dfs(i, j, hight);
                cnt++;
            }
        }
    }

    public static void dfs(int x, int y, int hight) {
        for(int i=0; i<4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) continue;
            if(visit[nextX][nextY] || map[nextX][nextY] <= hight) continue;
            visit[nextX][nextY] = true;
            dfs(nextX, nextY, hight);
        }
    }
}
