import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int answer = -1;
    static int[] cards;
    public static void main(String[] args) throws IOException {   
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cards = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0, 0);

        System.out.println(answer);
    } 

    static void dfs(int sum, int cnt, int current) {
        if(cnt == 3) {
            if(sum <= M) {
                if((M-answer) > (M-sum)) {
                    answer = sum;
                }
            }
            else {
                return;
            }
            return;
        }

        for(int i=current; i<N; i++) {
            dfs(sum+cards[i], cnt+1, i+1);
        }
    }
}
