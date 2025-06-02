package BOJ.Hyeon.one;

import java.io.*;
import java.util.*;

public class BOJ_2565_1 {
    static final int MAX = 501;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] cables = new int[MAX];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            cables[a] = b;
        }

        int[] dp = new int[MAX];

        for (int i = 1; i < MAX; i++) {
            if (cables[i] != 0) {
                dp[i] = 1;
                for (int j = 1; j < i; j++) {
                    if (cables[j] != 0 && cables[j] < cables[i]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
            }
        }

        int max = 1;

        for (int i = 1; i < MAX; i++) {
            max = Math.max(max, dp[i]);
        }

        System.out.println(N - max);
    }
}
