package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2670 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        double[] arr = new double[N];
        double[] dp = new double[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Double.parseDouble(br.readLine());
        }
        dp[0] = arr[0];

        double max = 0;
        for (int i = 1; i < N; i++) {
            dp[i] = Math.max(dp[i - 1] * arr[i], arr[i]);
            max = Math.max(max, dp[i]);
        }
        System.out.printf("%.3f", max);
    }
}

// S4 연속부분최대곱 DP
// 그냥 너무 쉬웠다.