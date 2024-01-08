import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] S;
    static int answer = Integer.MAX_VALUE;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {   
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        S = new int[N][N];
        visit = new boolean[N];

        StringTokenizer st;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            
            for(int j=0; j<N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        
        System.out.println(answer);
    }

    public static void dfs(int cnt, int current) {
        if(cnt == N/2) {
            answer = Math.min(answer, getDif());
            return;
        }

        for(int i=current; i<N; i++) {       
            if(!visit[i]) {
                visit[i] = true;
                dfs(cnt+1, i+1);
                visit[i] = false;
            }
        }
    }

    public static int getDif() {
        int A_sum = 0;
        int B_sum = 0;

        for(int i=0; i<N-1; i++) {
            for(int j=i+1; j<N; j++) {
                if(visit[i] == true && visit[j] == true) {
                    // i, j번째 두 사람이 모두 true이면 첫 번째 팀에 능력치 추가
                    A_sum += S[i][j];
                    A_sum += S[j][i];
                }
                else if(visit[i] == false && visit[j] == false) {
                    // i, j번째 두 사람이 모두 false이면 두 번째 팀에 능력치 추가
                    B_sum += S[i][j];
                    B_sum += S[j][i];
                }
            }
        }

        int dif = Math.abs(A_sum - B_sum); // 두 팀의 능력치 차이의 절대값

        if(dif == 0) { // 차이가 0이면 최솟값이므로 바로 0출력 후 종료
            System.out.println(dif);
            System.exit(0);
        }

        return dif; 
    }
}
