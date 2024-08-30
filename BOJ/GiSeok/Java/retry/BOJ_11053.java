/**
 * 11053 - 가장 긴 증가하는 부분 수열 [성공|00:19:47]
 * 실버2, DP, 시도1
 */
package BOJ.GiSeok.Java.retry;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_11053 {
    // 시간제한 1초, 메모리제한 256MB

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        int[] dp = new int[n];
        dp[0] = 1;

        for (int i = 1; i < n; i++) {
            int max = 1;
            for (int j = n-1; j >= 0; j--) {
                if (arr[j] < arr[i]) max = Math.max(max, dp[j] + 1);
            }

            dp[i] = max;
        }

        int ret = 0;
        for (int i = 0; i < n; i++) ret = Math.max(ret, dp[i]);

        System.out.println(ret);
    }
}
