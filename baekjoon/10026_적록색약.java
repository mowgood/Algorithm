import java.util.*;
import java.io.*;

public class Main {
    static String[][] map;
    static boolean[][] visit1, visit2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        map = new String[N][N];
        visit1 = new boolean[N][N]; //RGB
        visit2 = new boolean[N][N]; //RB

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                map[i][j] = str[j];
            }
        }

        int answer_RGB = 0;
        int answer_RB = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                String color = map[i][j];
                if (!visit1[i][j]) {
                    // RGB
                    dfs(i, j, color, true);
                    answer_RGB++;
                }
                if(!visit2[i][j]){
                    // RB
                    dfs(i, j, color, false);
                    answer_RB++;
                }
            }
        }

        System.out.println(answer_RGB + " "  + answer_RB);
    }

    public static void dfs(int x, int y, String color, boolean isRGB) {
        if (isRGB) visit1[x][y] = true;
        if (!isRGB) visit2[x][y] = true;

        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};

        for (int i = 0; i < dx.length; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX < 0 || nextX >= map.length || nextY < 0 || nextY >= map[0].length) continue;

            if (isRGB) {
                if (visit1[nextX][nextY]) continue;
                if (!RGB(nextX, nextY, color)) continue;
            }
            else if (!isRGB) {
                if (visit2[nextX][nextY]) continue;
                if (!RB(nextX, nextY, color)) continue;
            }

            dfs(nextX, nextY, color, isRGB);
        }
    }

    public static boolean RB(int nextX, int nextY, String color) {
        if (color.equals("R") || color.equals("G")) {
            if (!map[nextX][nextY].equals("R") && !map[nextX][nextY].equals("G")) return false;
        }
        else if (color.equals("B")) {
            if (!color.equals(map[nextX][nextY])) return false;
        }

        return true;
    }

    public static boolean RGB(int nextX, int nextY, String color) {
        if (!color.equals(map[nextX][nextY])) return false;
        return true;
    }
}
