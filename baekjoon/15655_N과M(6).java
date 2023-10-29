import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[N];
        arr = new int[M];

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);

        dfs(0, 0);

        System.out.println(sb);
    }

    static void dfs(int current, int cnt) {
        if(cnt == M) {
            for(int i : arr) {
                sb.append(i + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i=current; i<N; i++) {
            arr[cnt] = numbers[i];
            dfs(i+1, cnt+1);
        }
        return;  
    }
}
