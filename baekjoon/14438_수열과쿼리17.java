import java.util.*;
import java.io.*;

public class Main {
    static int[] arr, tree;
    public static void main(String[] args) throws IOException {   
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        tree = new int[N*4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        init(1, N, 1);

        int M = Integer.parseInt(br.readLine());

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a==1) {
                // arr[b] = c;
                update(1, N, 1, b, c);
            }
            else if(a==2) {
                sb.append(getMin(1, N, 1, b, c) + "\n");
            }
        }

        System.out.println(sb);
        br.close();
    }

    public static int init(int start, int end, int node) {
        // 리프노드
        if(start == end) {
            return tree[node] = arr[start];
        }

        int mid = (start + end) / 2;
        return tree[node] = Math.min(init(start, mid, node*2), init(mid+1, end, node*2+1));
    }

    public static int update(int start, int end, int node, int idx, int c) {
        if(idx < start || idx > end) {
            return tree[node];
        }

        // 리프노드
        if(start == end) {
            return tree[node] = c;
        }

        int mid = (start + end) / 2;
        return tree[node] = Math.min(update(start, mid, node*2, idx, c), update(mid+1, end, node*2+1, idx, c));
    }

    public static int getMin(int start, int end, int node, int left, int right) {
        if(left > end || right < start) {
            return Integer.MAX_VALUE;
        }

        if(left <= start && right >= end) {
            return tree[node];
        }

        int mid = (start + end) / 2;
        return Math.min(getMin(start, mid, node*2, left, right), getMin(mid+1, end, node*2+1, left, right));
    }
}
