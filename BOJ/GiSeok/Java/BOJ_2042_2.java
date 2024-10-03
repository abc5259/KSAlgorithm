package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2042_2 {

    static long[] tree;
    static long[] a;
    static int n, m, k;

    static void init() {
        for (int i = 1; i <= n; i++) {
            for (int j = i; j > i - (i & -i); j--) {
                tree[i] += a[j];
            }
        }
    }

    static long find(int i) {
        long sum = 0;
        for (int idx = i; idx > 0; idx -= (idx & -idx)) sum += tree[idx];
        return sum;
    }

    static void update(int b, long diff) {
        for (int idx = b; idx <= n; idx += (idx & -idx)) tree[idx] += diff;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        a = new long[n+1];
        tree = new long[n+1];
        for (int i = 1; i <= n; i++) a[i] = Long.parseLong(br.readLine());
        init();

        for (int i = 0; i < m+k; i++) {
            st = new StringTokenizer(br.readLine());
            int flag = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (flag == 1) { update(b, c - a[b]); a[b] = c; }
            else System.out.println(find((int)c) - find(b-1));
        }
    }
}
