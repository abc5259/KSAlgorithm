/**
 * 1912 - 연속합 [성공|00:04:25]
 * 실버2, DP, 시도1
 */
package BOJ.GiSeok.Java.retry;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1912 {
    // 시간제한 1초, 메모리제한 128MB

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n];

        int ret = Integer.MIN_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            dp[i] = Integer.parseInt(st.nextToken());
            if (i != 0) dp[i] = Math.max(dp[i], dp[i] + dp[i-1]);
            ret = Math.max(ret, dp[i]);
        }

        System.out.println(ret);
    }
}
