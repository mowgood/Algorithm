import java.util.*;
import java.io.*;

public class Main {
    static Deque<Integer> dq;
    static boolean first;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {   
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while(T > 0) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), "[],");

            dq = new ArrayDeque<>();

            for(int i=0; i<n; i++) {
                dq.offer(Integer.parseInt(st.nextToken()));
            }

            if(AC(p)) {
                sb.append("[");

                if(dq.size() > 0) {
                    if(first) {
                        sb.append(dq.pollFirst());

                        while(!dq.isEmpty()) {
                            sb.append("," + dq.pollFirst());
                        }
                    }
                    else {
                        sb.append(dq.pollLast());

                        while(!dq.isEmpty()) {
                            sb.append("," + dq.pollLast());
                        }
                    }
                }
                sb.append("]\n");
            }

            T--;
        }

        System.out.println(sb);
    }

    public static boolean AC(String p) {
        first = true;
        for(int i=0; i<p.length(); i++) {
            if(p.charAt(i) == 'R') {
                // 뒤집기
                first = !first;
                continue;
            }

            if(dq.size() == 0) {
                // 에러 발생
                sb.append("error\n");
                return false;
            }
            
            if(first) {
                dq.pollFirst();
            }
            else {
                dq.pollLast();
            }
        }
        return true;
    }
}
