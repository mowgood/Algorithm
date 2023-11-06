import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] values = new int[N];

        for(int i=0; i<N; i++) {
            values[i] = Integer.parseInt(br.readLine());
        }

        int answer = 0;
        for(int i=N-1; i>=0; i--) {
            answer += K / values[i];
            K %= values[i];
        }

        System.out.println(answer);
        
    }
}
