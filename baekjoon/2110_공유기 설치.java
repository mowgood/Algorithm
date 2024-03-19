import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] house = new int[N];

        for (int i = 0; i < N; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(house);

        System.out.println(upperBound(house, C) - 1);
    }

    public static int upperBound(int[] house, int C) {
        int min = 1;
        int max = house[house.length-1] - house[0] + 1;
        int mid;

        /**
         * Upper Bound
         */
        while (min < max) {
            mid = (min + max) / 2;
            if (getCnt(house, mid) < C) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        return min;
    }

    /**
     * 최소 거리가 distance 일때, 설치 가능한 공유기 개수 구하기
     */
    public static int getCnt(int[] house, int distance) {
        int cnt = 1;
        int current = 0;

        for (int i = current+1; i < house.length; i++) {
            if (house[i] - house[current] >= distance) {
                current = i;
                cnt++;
            }
        }

        return cnt;
    }
}
