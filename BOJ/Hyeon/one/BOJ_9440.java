package BOJ.Hyeon.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_9440 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            if (N == 0) {
                break;
            }

            int[] q = new int[N];
            for (int i = 0; i < N; i++) {
                q[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(q);
            zero(q);

            int[] arr = new int[N - (N / 2)];
            int[] brr = new int[N / 2];

            int aCnt = 0, bCnt = 0;
            for (int i = 0; i < N; i++) {
                if (i % 2 == 0) {
                    arr[aCnt++] = q[i];
                } else {
                    brr[bCnt++] = q[i];
                }
            }
            if (arr[0] == 0) {
                zero(arr);
            }
            if (brr[0] == 0) {
                zero(brr);
            }
            int res = sum(arr) + sum(brr);
            sb.append(res).append("\n");
        }
        System.out.println(sb);
    }

    private static void zero(int[] t) {
        for (int i = 0; i < t.length; i++) {
            if (t[0] == 0 && t[i] != 0) {
                swap(i, t);
                break;
            }
        }
    }

    private static void swap(int idx, int[] t) {
        int tmp = t[0];
        t[0] = t[idx];
        t[idx] = tmp;
    }

    private static int sum(int[] t) {
        int ans = 0;
        for (int i = 0; i < t.length; i++) {
            ans += t[i] * (int) Math.pow(10, t.length - 1 - i);
        }
        return ans;
    }
}

// S2 숫자 더하기 그리디
// 다시 풀어보자