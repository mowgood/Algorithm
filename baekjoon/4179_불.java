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

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        
        String[][] map = new String[R][C];
        int[][] dist = new int[R][C]; // 불 전파 시간
        int[][] dist2 = new int[R][C]; // 지훈이 이동 시간
        Queue<Point> jihoon = new LinkedList<>();
        Queue<Point> fire = new LinkedList<>();
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};

        for(int i=0; i<R; i++) {
            String[] str = br.readLine().split("");
            Arrays.fill(dist[i], -1);
            Arrays.fill(dist2[i], -1);
            for(int j=0; j<C; j++) {
                map[i][j] = str[j];
                if(map[i][j].equals("F")) {
                    fire.offer(new Point(i, j));
                    dist[i][j] = 0;
                }

                if(map[i][j].equals("J")) {
                    jihoon.offer(new Point(i, j));
                    dist2[i][j] = 0;
                }
            }
        }

        // 불 BFS
        while(!fire.isEmpty()) {
            Point nowFire = fire.poll();

            for(int i=0; i<4; i++) {
                int nextFireX = nowFire.x + dx[i];
                int nextFireY = nowFire.y + dy[i];

                if(nextFireX < 0 || nextFireX >= R || nextFireY < 0 || nextFireY >= C) continue;
                if(dist[nextFireX][nextFireY] >= 0 || map[nextFireX][nextFireY].equals("#")) continue;
                
                dist[nextFireX][nextFireY] = dist[nowFire.x][nowFire.y] + 1;
                fire.offer(new Point(nextFireX, nextFireY));
            }
        }

        // 지훈 BFS
        while(!jihoon.isEmpty()) {
            Point nowJihoon = jihoon.poll();

            for(int i=0; i<4; i++) {
                int nextJihoonX = nowJihoon.x + dx[i];
                int nextJihhonY = nowJihoon.y + dy[i];

                // 범위를 벗어나면 탈출 성공
                if(nextJihoonX < 0 || nextJihoonX >= R || nextJihhonY < 0 || nextJihhonY >= C) {
                    System.out.println(dist2[nowJihoon.x][nowJihoon.y] + 1);
                    return;
                }

                if(dist2[nextJihoonX][nextJihhonY] >= 0 || map[nextJihoonX][nextJihhonY].equals("#")) continue;

                // 불이 전파된 시간과 비교
                if(dist[nextJihoonX][nextJihhonY] != -1 && dist[nextJihoonX][nextJihhonY] <= dist2[nowJihoon.x][nowJihoon.y]+1) continue;
                
                dist2[nextJihoonX][nextJihhonY] = dist2[nowJihoon.x][nowJihoon.y] + 1;
                jihoon.offer(new Point(nextJihoonX, nextJihhonY));
            }
        }
        System.out.println("IMPOSSIBLE");
        return;
    }
}
