/**
 * 11053 - 가장 긴 증가하는 부분 수열 [성공|00:02:00]
 * 실버2, LCS/DP, 시도1
 */
package BOJ.GiSeok.Java.retry;
import java.io.*;
import java.util.StringTokenizer;

public class BOJ_11053 {
    // 시간제한 1초, 메모리제한 256MB

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[n];
        for (int i = 0; i < n; i++) A[i] = Integer.parseInt(st.nextToken());

        int[] dp = new int[n];
        dp[0] = 1;
        int ret = dp[0];
        for (int i = 1; i < n; i++) {
            int len = 0;
            for (int j = i-1; j >= 0; j--) {
                if (A[i] > A[j]) len = Math.max(len, dp[j]);
            }

            dp[i] = len + 1;
            ret = Math.max(ret, dp[i]);
        }

        System.out.println(ret);
    }
}
