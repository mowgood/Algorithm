import java.util.*;
import java.io.*;

public class Main {
    public static class Point {
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N;
    static int[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int cnt = 0;
    public static void main(String[] args) throws IOException {   
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int i=0; i<N; i++) {
            String s = br.readLine();
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }

        List<Integer> answers = new LinkedList<>();
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(map[i][j] != 1) continue;
                bfs(i, j);
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

    public static void bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y));
        map[x][y] = 0;
        cnt++;

        while(!q.isEmpty()) {
            Point now = q.poll();
            int nowX = now.x;
            int nowY = now.y;

            for(int i=0; i<4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) continue;
                if(map[nextX][nextY] != 1) continue;

                map[nextX][nextY] = 0;
                cnt++;
                q.offer(new Point(nextX, nextY));
            } 
        }
    }
}
