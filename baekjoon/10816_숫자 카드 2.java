import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            sb.append(upperBound(arr, num) - lowerBound(arr, num)).append(' ');
        }

        System.out.println(sb);
    }

    public static int lowerBound(int[] arr, int num) {
        int min = 0;
        int max = arr.length;
        int mid;

        while(min < max) {
            mid = (min + max) / 2;

            if (num <= arr[mid]) {
                max = mid;
            }
            else {
                min = mid + 1;
            }
        }
        return min;
    }

    public static int upperBound(int[] arr, int num) {
        int min = 0;
        int max = arr.length;
        int mid;

        while(min < max) {
            mid = (min + max) / 2;

            if (num < arr[mid]) {
                max = mid;
            }
            else {
                min = mid + 1;
            }
        }
        return min;
    }
}
