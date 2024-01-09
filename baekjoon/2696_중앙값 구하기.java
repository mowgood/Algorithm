import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {   
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            int M = Integer.parseInt(br.readLine());
            sb.append((M+1)/2 + "\n"); // 중앙값의 개수

            int cnt = 0; // 한 줄에 10개씩 출력하기 위해 카운트
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();

            for(int i=0; i<M; i++) {
                if(i%10==0) {
                    st = new StringTokenizer(br.readLine());
                }

                int num = Integer.parseInt(st.nextToken());

                if(maxHeap.size() == minHeap.size()) {
                    maxHeap.offer(num);
                } else {
                    minHeap.offer(num);
                }

                // maxHeap은 중앙값 이하 숫자만 가진다.
                if(!minHeap.isEmpty() && !maxHeap.isEmpty()) {
                    if(maxHeap.peek() > minHeap.peek()) {
                        int tmp = maxHeap.poll();
                        maxHeap.offer(minHeap.poll());
                        minHeap.offer(tmp);
                    }
                }

                // 인덱스는 0부터 시작한다. -> 짝수 인덱스일 때가 홀수 번째이다.
                if(i%2==0) {
                    cnt++;
                    if(cnt%10==0 || i==M-1) {
                        sb.append(maxHeap.peek() + "\n");
                    } else {
                        sb.append(maxHeap.peek() + " ");
                    }
                }
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
