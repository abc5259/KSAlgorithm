/**
 * [G2 DP] 가장 긴 증가하는 부분 수열 2 - X, 01:23:34
 * 시도 6
 */
package BOJ.GiSeok.Java.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12015 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] sequence = new int[n];
        for (int i = 0; i < n; i++) sequence[i] = Integer.parseInt(st.nextToken());

        int[] dp = new int[n];
        dp[0] = sequence[0];
        int idx = 1;
        for (int i = 1; i < n; i++) {
            if (dp[idx-1] < sequence[i]) {
                dp[idx++] = sequence[i];
            } else {
                int left = -1;
                int right = idx;

                while (left + 1 < right) {
                    int mid = (left + right) / 2;

                    if (dp[mid] >= sequence[i]) right = mid;
                    else left = mid;
                }
                dp[right] = sequence[i];
            }
        }
        System.out.println(idx);
    }
}
