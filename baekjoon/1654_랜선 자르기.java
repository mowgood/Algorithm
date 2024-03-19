import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[K];

        long max = 0;
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (arr[i] > max) max = arr[i];
        }
        max++; // 가장 긴 랜선이 최대 길이일 경우 포함

        long answer = binarySearch(arr, max, N);
        System.out.println(answer - 1); // Upper Bound - 1
        br.close();
    }

    public static long binarySearch(int[] arr, long max, int N) {
        long mid = 0;
        long min = 0;
        long cnt;

        while(min < max) {
            mid = (min + max) / 2;
            cnt = 0;

            for(int num : arr) {
                cnt += num / mid;
            }

            if (cnt < N) {
                max = mid;
            }
            else {
                min = mid + 1;
            }
        }

        return (min + max) / 2;
    }
}
