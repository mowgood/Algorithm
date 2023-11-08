import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] w = new int[N];

        for(int i=0; i<N; i++) {
            w[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(w);

        int answer = Integer.MIN_VALUE;
        for(int i=0; i<N; i++) {
            answer = Math.max(answer, w[i]*(N-i));
        }
        System.out.println(answer);
    }
}
