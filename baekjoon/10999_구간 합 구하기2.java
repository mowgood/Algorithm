import java.io.*;
import java.util.*;

public class Main {
    private static long[] tree, lazy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        tree = new long[N * 4];
        lazy = new long[N * 4];
        for (int i = 1; i <= N; i++) {
            update(1, N, 1, i, i, Long.parseLong(br.readLine()));
        }

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            if (Integer.parseInt(st.nextToken()) == 1) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                long c = Long.parseLong(st.nextToken());
                update(1, N, 1, a, b, c);
            } else {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                sb.append(sum(1, N, 1, a, b) + "\n");
            }
        }

        System.out.print(sb);
        br.close();
    }

    public static void update(int start, int end, int node, int left, int right, long dif) {
        propagate(start, end, node);
        if (left <= start && end <= right) {
            lazy[node] += dif;
            propagate(start, end, node);
        } else if (!(start > right || end < left)) {
            int mid = (start + end) / 2;
            update(start, mid, node * 2, left, right, dif);
            update(mid + 1, end, node * 2 + 1, left, right, dif);
            tree[node] = tree[node * 2] + tree[node * 2 + 1];
        }
    }

    public static void propagate(int start, int end, int node) {
        if (lazy[node] != 0) {
            tree[node] += (end - start + 1) * lazy[node];
            if (start < end) {
                lazy[node * 2] += lazy[node];
                lazy[node * 2 + 1] += lazy[node];
            }
            lazy[node] = 0;
        }
    }

    public static long sum(int start, int end, int node, int left, int right) {
        propagate(start, end, node);
        if (left <= start && end <= right) {
            return tree[node];
        } else if (!(start > right || end < left)) {
            int mid = (start + end) / 2;
            return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right);
        } else {
            return 0;
        }
    }
}
