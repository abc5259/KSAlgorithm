package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_12852 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];

        for (int i = N; i > 1; i--) {
            if (dp[i - 1] != 0) {
                dp[i - 1] = Math.min(dp[i - 1], dp[i] + 1);
            } else {
                dp[i - 1] = dp[i] + 1;
            }

            if (i % 2 == 0 && dp[i / 2] != 0) {
                dp[i / 2] = Math.min(dp[i / 2], dp[i] + 1);
            } else {
                dp[i / 2] = dp[i] + 1;
            }
            if (i % 3 == 0 && dp[i / 3] != 0) {
                dp[i / 3] = Math.min(dp[i / 3], dp[i] + 1);
            } else {
                dp[i / 3] = dp[i] + 1;
            }
        }

        System.out.println(dp[N]);

        while (N > 0) {

        }
    }
}
