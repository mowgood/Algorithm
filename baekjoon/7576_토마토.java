import java.io.*;
import java.util.*;

class Point {
    int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        Queue<Point> q = new LinkedList<>();
        int[][] map = new int[N][M];
        int[][] dist = new int[N][M];
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        int day = 0;
        
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) {
                    q.offer(new Point(i, j));
                }
                if(map[i][j] == 0) {
                    dist[i][j] = -1;
                }
            }
        }

        while(!q.isEmpty()) {
            Point now =q.poll();

            for(int i=0; i<4; i++) {
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];

                if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) continue;
                if(dist[nextX][nextY] >= 0) continue;

                dist[nextX][nextY] = dist[now.x][now.y] + 1;
                q.offer(new Point(nextX, nextY));
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(dist[i][j] == -1) {
                    System.out.println(-1);
                    return;
                }
                day = Math.max(day, dist[i][j]);
            }
        }
        System.out.println(day);
    }
}
