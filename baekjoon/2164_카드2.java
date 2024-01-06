import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {   
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> dq = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());

        for(int i=1; i<=N; i++) {
            dq.offerFirst(i);
        }

        while(dq.size() != 1) {
            dq.pollLast();
            dq.offerFirst(dq.pollLast());
        }

        System.out.println(dq.peek());
    }
}
