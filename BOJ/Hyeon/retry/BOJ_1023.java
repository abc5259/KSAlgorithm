package BOJ.Hyeon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1023 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken());


        long[][] dp = new long[N + 1][N + 2];

        dp[0][0] = 1;
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                dp[i][j] = dp[i - 1][j + 1];

                if (j > 0) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }

        long total = (1L << N) - dp[N][0];

        if (K >= total) {
            System.out.println(-1);
            return;
        }

        StringBuilder sb = new StringBuilder();
        int open = 0;
        boolean flag = false;

        for (int i = 0; i < N; i++) {
            int jari = N - 1 - i;
            long left;

            if (flag) {
                left = 1L << jari;
            } else {
                long cnt = (open + 1 <= N) ? dp[jari][open + 1] : 0;
                left = (1L << jari) - cnt;
            }

            if (K < left) {
                sb.append("(");
                open++;
            } else {
                sb.append(")");
                K -= left;
                open--;
                if (open < 0) {
                    flag = true;
                }
            }
        }

        System.out.println(sb);
    }
}
// P3 괄호 문자열 DP
// 1시간
// 바텀업으로 접근했는데 답보고 했다 너무 어려운 문제 괜히 도전했다.