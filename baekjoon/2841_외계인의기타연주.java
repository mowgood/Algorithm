import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {   
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;

        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        Stack<Integer>[] stack = new Stack[7];
        for(int i=1; i<7; i++) {
            stack[i] = new Stack<>();
        }

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int line = Integer.parseInt(st.nextToken());
            int pNum = Integer.parseInt(st.nextToken());

            while(!stack[line].isEmpty()) {
                if(stack[line].peek() < pNum) {
                    stack[line].push(pNum);
                }
                else if(stack[line].peek() > pNum) {
                    stack[line].pop();
                }
                else {
                    break;
                }
                answer++;
            }

            if(stack[line].isEmpty()) {
                stack[line].push(pNum);
                answer++;
            }

        }

        System.out.println(answer);
    }
}
