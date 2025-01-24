/**
 * [G3 DP] 앱 - X
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_7579 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n, m;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[] memory = new int[n+1];
        int[] cost = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) memory[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) cost[i] = Integer.parseInt(st.nextToken());

        int[][] dp = new int[n+1][100001];
        int ret = Integer.MAX_VALUE;
        for (int app = 1; app <= n; app++) {
            for (int co = 0; co <= 10000; co++) {
                if (co >= cost[app]) dp[app][co] = Math.max(dp[app-1][co - cost[app]] + memory[app], dp[app-1][co]);
                else dp[app][co] = dp[app - 1][co];

                if (dp[app][co] >= m) ret = Math.min(ret, co);
            }
        }

        System.out.println(ret);
    }
}