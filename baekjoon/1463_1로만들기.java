import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        
        int[] d = new int[1000005];
        d[1] = 0;

        for(int i=2; i<=N; i++) {
            d[i] = d[i-1] + 1;
            if(i%2 == 0) d[i] = Math.min(d[i], d[i/2]+1);
            if(i%3 == 0) d[i] = Math.min(d[i], d[i/3]+1);
        }
        System.out.println(d[N]);
    }
}
