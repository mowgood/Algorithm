import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] picture = new int[N][M];
        boolean[][] visit = new boolean[N][M];
        int totalCnt = 0;
        int cnt = 0;
        int maxValue = 0;

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                picture[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Point> q = new LinkedList<>();
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        for (int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(visit[i][j] || picture[i][j] != 1) continue;

                q.offer(new Point(i, j));
                visit[i][j] = true;
                cnt = 1;
                totalCnt++;

                while(!q.isEmpty()) {
                    Point now = q.poll();
                    
                    for (int k=0; k<4; k++) {
                        int nextX = now.x + dx[k];
                        int nextY = now.y + dy[k];

                        if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) continue;
                        if (visit[nextX][nextY] || picture[nextX][nextY] != 1) continue;

                        visit[nextX][nextY] = true;
                        cnt++;
                        q.offer(new Point(nextX, nextY));
                    }
                }
                maxValue = Math.max(maxValue, cnt);
            }
        }
        System.out.println(totalCnt + "\n" + maxValue);
    }
    
    public static class Point {
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
