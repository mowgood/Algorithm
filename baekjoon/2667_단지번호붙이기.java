import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int cnt = 0;
    public static void main(String[] args) throws IOException {   
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visit = new boolean[N][N];

        for(int i=0; i<N; i++) {
            String s = br.readLine();
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }

        List<Integer> answers = new LinkedList<>();

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(visit[i][j] || map[i][j] != 1) continue;
                dfs(i, j);
                answers.add(cnt);
                cnt = 0;
            }
        }

        System.out.println(answers.size());
        Collections.sort(answers);
        for(int i : answers) {
            System.out.println(i);
        }
    } 

    public static void dfs(int x, int y) {
        cnt++;
        visit[x][y] = true;
        for(int i=0; i<4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) continue;
            if(visit[nextX][nextY] || map[nextX][nextY] != 1) continue;          
            dfs(nextX, nextY);
        }
    }
}
