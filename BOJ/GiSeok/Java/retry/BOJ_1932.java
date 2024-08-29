/**
 * 1932 - 정수 삼각형 [성공|00:16:08]
 * 실버1, DP, 시도1
 */
package BOJ.GiSeok.Java.retry;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1932 {
    // 시간제한 2초, 메모리제한 128MB
    static int[][] nums;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        dp = new int[n][n];
        nums = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) nums[i][j] = Integer.parseInt(st.nextToken());
        }

        dp[0][0] = nums[0][0];
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j <= i; j++) {
                dp[i+1][j] = Math.max(dp[i+1][j], nums[i+1][j] + dp[i][j]);
                dp[i+1][j+1] = Math.max(dp[i+1][j+1], nums[i+1][j+1] + dp[i][j]);
            }
        }

        int ret = 0;
        for (int i = 0; i < n; i++)
            ret = Math.max(ret, dp[n-1][i]);
        System.out.println(ret);
    }
}
