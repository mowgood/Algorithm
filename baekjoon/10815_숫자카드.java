import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] cards;
    public static void main(String[] args) throws IOException {   
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        cards = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cards);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(binarySearch(num))  bw.write("1 ");
            else bw.write("0 ");
        }

        bw.close();
        br.close();
    }

    public static boolean binarySearch(int num) {
        int leftIdx = 0;
        int rightIdx = N-1;

        while(leftIdx <= rightIdx) {
            int midIdx = (leftIdx + rightIdx) / 2;
            int mid = cards[midIdx];

            if(num < mid) rightIdx = midIdx - 1;
            else if(num > mid) leftIdx = midIdx + 1;
            else return true;
        }
        return false;
    }
}
