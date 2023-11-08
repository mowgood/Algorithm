import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        int[] A = new int[N];
        int[] B = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            A[i] = Integer.parseInt(st.nextToken());    
            B[i] = Integer.parseInt(st2.nextToken());           
        }

        Arrays.sort(A);
        Arrays.sort(B);

        int answer = 0;
        for(int i=0; i<N; i++) {
            answer += A[i] * B[N-1-i];
        }

        System.out.println(answer);
        
    }
}
