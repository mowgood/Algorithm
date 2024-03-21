import java.util.*;
import java.io.*;

public class Main {
    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);

        System.out.print(answer);
    }

    /**
     * 벽을 3개 세운다.
     */
    public static void dfs(int wall) {
        if (wall == 3) {
            bfs();
            return;
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(wall + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    /**
     * 바이러스를 퍼트린다.
     */
    public static void bfs() {
        Queue<Node> queue = new LinkedList<>();

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 2) {
                    queue.offer(new Node(i, j));
                }
            }
        }

        // 원본 배열을 변경하면 안되기 때문에 깊은 복사를 사용한다.
        int[][] copyMap = new int[map.length][map[0].length];
        for (int i = 0; i < map.length; i++) {
            copyMap[i] = map[i].clone();
        }

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            for (int i = 0; i < dx.length; i++) {
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];

                if (nextX < 0 || nextX >= map.length || nextY < 0 || nextY >= map[0].length) continue;
                if (copyMap[nextX][nextY] == 0) {
                    copyMap[nextX][nextY] = 2;
                    queue.offer(new Node(nextX, nextY));
                }
            }
        }

        getMaxSafeZone(copyMap);
    }

    /**
     * 안전 영역의 최대 크기를 찾는다.
     */
    public static void getMaxSafeZone(int[][] copyMap) {
        int cnt = 0;
        for (int i = 0; i < copyMap.length; i++) {
            for (int j = 0; j < copyMap[i].length; j++) {
                if (copyMap[i][j] == 0) cnt++;
            }
        }
        answer = Math.max(answer, cnt);
    }
}
