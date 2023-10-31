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
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        int[][] dist = new int[N][M];
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};

        for (int i=0; i<N; i++) {
            String[] str = br.readLine().split("");
            Arrays.fill(dist[i], -1);
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(str[j]);
            }
        }

        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0, 0));
        dist[0][0] = 1;

        while(!q.isEmpty()) {
            Point now = q.poll();

            for(int i=0; i<4; i++) {
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];

                if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) continue;
                if(dist[nextX][nextY] >= 0 || map[nextX][nextY] != 1) continue;

                dist[nextX][nextY] = dist[now.x][now.y] + 1;
                q.offer(new Point(nextX, nextY));
            }
        }
        System.out.println(dist[N-1][M-1]);
    }
}
