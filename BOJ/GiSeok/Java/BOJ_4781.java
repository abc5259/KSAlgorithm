/**
 * 4781 - 사탕 가게 [성공|00:57:57]
 * 골드4, DP, 시도2
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_4781 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = (int) Math.round(Double.parseDouble(st.nextToken()) * 100);

            if (n == 0 && m == 0) break;

            int[] cal = new int[n];
            int[] price = new int[n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                cal[i] = Integer.parseInt(st.nextToken());
                price[i] = (int) Math.round(Double.parseDouble(st.nextToken()) * 100);
            }

            int[] dp = new int[10001];
            for (int i = 0; i < n; i++) {

                for (int j = price[i]; j <= m; j++) {
                    dp[j] = Math.max(dp[j], dp[j - price[i]] + cal[i]);
                }
            }

            System.out.println(dp[m]);
        }
    }
}
