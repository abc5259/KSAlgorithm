/**
 * 2670 - 연속부분최대곱 [성공|00:10:12]
 * 실버4, DP, 시도1
 */
package BOJ.GiSeok.Java.retry;

import java.io.*;

public class BOJ_2670 {
    // 시간제한 1초, 메모리제한 128MB

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        double[] a = new double[n];
        for (int i = 0; i < n; i++) a[i] = Double.parseDouble(br.readLine());

        double ret = 0;
        double[] dp = new double[n];
        dp[0] = a[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(a[i], a[i] * dp[i-1]);
            ret = Math.max(ret, dp[i]);
        }

        System.out.println(String.format("%.3f", ret));
    }
}
