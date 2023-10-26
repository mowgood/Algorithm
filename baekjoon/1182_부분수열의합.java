import java.io.*;
import java.util.*;

class Main {
    static int N, S;
    static int count;
    static  int[] numbers;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        numbers = new int[N];

        for(int i=0; i<numbers.length; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);
        
        if(S == 0) {
            System.out.println(answer-1);
        } else {
            System.out.println(answer);
        }
    }

    private static void dfs(int depth, int sum) {
        if(depth == N) {
            if(sum == S) {
                answer++;
            }
            return;
        }
        dfs(depth+1, sum);
        dfs(depth+1, sum + numbers[depth]);
    }
}
