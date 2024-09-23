/**
 * 12865 - 평범한 배낭 [성공|00:21:33]
 * 골드5, DP, 시도2
 */
package BOJ.GiSeok.Java.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12865 {
    // 시간제한 2초, 메모리제한 512MB

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] dp = new int[k+1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            for (int j = k; j >= w; j--)
                dp[j] = Math.max(dp[j], dp[j - w] + v);
        }

        System.out.println(dp[k]);
    }
}
