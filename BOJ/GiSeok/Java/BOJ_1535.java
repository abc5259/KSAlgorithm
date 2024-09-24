/**
 * 1535 - 안녕 [성공|00:09:14]
 * 실버2, DP, 시도1
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1535 {

    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] hp = new int[n];
        int[] joy = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) hp[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) joy[i] = Integer.parseInt(st.nextToken());

        dp = new int[101];
        for (int i = 0; i < n; i++) {

            for (int life = 100; life >= hp[i]; life--)
                dp[life] = Math.max(dp[life], dp[life - hp[i]] + joy[i]);
        }

        System.out.println(dp[99]);
    }
}
