import java.io.*;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dfs("");
    }

    public static void dfs(String str) {
        if (str.length() == N) {
            System.out.print(str);
            System.exit(0);
        }
        for (int i = 1; i <= 3; i++) {
            if (isGood(str + i)) dfs(str + i);
        }
    }

    public static boolean isGood(String str) {
        for (int i = 1; i <= str.length() / 2; i++) {
            String front = str.substring(str.length() - i * 2, str.length() - i);
            String back = str.substring(str.length() - i, str.length());
            if (front.equals(back)) return false;
        }
        return true;
    }
}
