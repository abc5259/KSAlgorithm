package BOJ.Hyeon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[n + 1];
        if (n == 1) {
            dp[1] = arr[1];
        } else if (n == 2) {
            dp[2] = arr[1] + arr[2];
        } else {
            dp[1] = arr[1];
            dp[2] = arr[1] + arr[2];
            dp[3] = arr[3] + Math.max(arr[2], arr[1]);

            for (int i = 4; i <= n; i++) {
                dp[i] = arr[i] + Math.max(dp[i - 2], dp[i - 3] + arr[i - 1]);
            }
        }
        System.out.println(dp[n]);
    }
}
