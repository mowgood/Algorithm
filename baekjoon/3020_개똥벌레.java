import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {   
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[] floor = new int[H+1]; // 석순
        int[] ceil = new int[H+1]; // 종유석

        // 장애물 크기별 개수 구하기
        for(int i=0; i<N/2; i++) {
            // 석순과 종유석이 번갈아가면서 등장한다
            floor[Integer.parseInt(br.readLine())]++;
            ceil[Integer.parseInt(br.readLine())]++;
        }

        // 구간 합 구하기
        for(int i=H-1; i>0; i--) {
            floor[i] += floor[i+1];
            ceil[i] += ceil[i+1];
        }

        int[] block = new int[H+1]; // 각 높이에서 장애물을 만난 횟수
        int min = N+1;
        int cnt = 0;
        for(int i=1; i<H+1; i++) {
            block[i] = floor[i] + ceil[H-i+1];
            if(block[i] == min) {
                cnt++;
                continue;
            }
            if(block[i] < min) {
                min = block[i];
                cnt = 1;
            }
        }

        System.out.println(min + " " + cnt); 
    } 
}
