/**
 * 2342 - 구간 합 구하기(G1) [O|01:14:56]
 * 세그먼트 트리, 시도9
 */
package BOJ.GiSeok.Java;

import java.io.*;
import java.util.*;

public class BOJ_2042 {

    static long[] tree;
    static long[] a;
    static int n, m, k;

    static long go(int idx, int start, int end) {

        if (start == end) {
            tree[idx] = a[start];
            return tree[idx];
        }

        tree[idx] += go(2*idx, start, (start+end)/2);
        tree[idx] += go(2*idx+1, (start+end)/2+1, end);

        return tree[idx];
    }

    static long find(int idx, int start, int end, int left, int right) {

        if (left > end || right < start) return 0;
        if (start >= left && end <= right) return tree[idx];

        long sum = 0;
        sum += find(idx*2, start, (start+end)/2, left, right);
        sum += find(idx*2+1, (start+end)/2+1, end, left, right);

        return sum;
    }

    static void update(int idx, int start, int end, int findIdx, long diff) {
        if (start > findIdx || end < findIdx) return;

        tree[idx] += diff;
        if (start == end) return;
        update(idx*2, start, (start+end)/2, findIdx, diff);
        update(idx*2+1, (start+end)/2+1, end, findIdx, diff);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 수의 개수
        m = Integer.parseInt(st.nextToken()); // 수의 변경
        k = Integer.parseInt(st.nextToken()); // 구간합 횟수

        a = new long[n+1];
        tree = new long[(n+1) * 4];
        for (int i = 1; i <= n; i++) a[i] = Long.parseLong(br.readLine());
        go(1, 1, n);

        for (int i = 0; i < m+k; i++) {
            st = new StringTokenizer(br.readLine());
            int flag = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (flag == 1) { update(1, 1, n, b, c - a[b]); a[b] = c; }
            else if (flag == 2) System.out.println(find(1, 1, n, b, (int)c));
        }
    }
}