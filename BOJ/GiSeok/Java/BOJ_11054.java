/**
 * 11054 - 가장 긴 바이토닉 부분 수열 [실패|01:08:27]
 * 골드4, DP, 시도4
 */
package BOJ.GiSeok.Java;
import java.io.*;
import java.util.StringTokenizer;

public class BOJ_11054 {
    // 시간제한 1초, 메모리제한 256MB

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) dp[i][0] = Math.max(dp[i][0], dp[j][0] + 1);
            }
        }

        for (int i = n-1; i >= 0; i--) {
            dp[i][1] = 1;
            for (int j = n-1; j > i; j--) {
                if (arr[i] > arr[j]) dp[i][1] = Math.max(dp[i][1], dp[j][1] + 1);
            }
        }

        int ret = 0;
        for (int i = 0; i < n; i++)
            ret = Math.max(ret, dp[i][0] + dp[i][1] - 1);

        System.out.println(ret);
    }
}
