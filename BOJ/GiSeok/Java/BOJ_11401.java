/**
 * [G1 수학/모듈러] 이항 계수 3 - X, 00:40:20
 * 시도 9
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11401 {

    private static final int DIVIDE_NUM = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        long[] dp = new long[n+1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i] = (i * dp[i - 1]) % DIVIDE_NUM;
        }
        long denom = dp[k] * dp[n-k] % DIVIDE_NUM;
        long ret = dp[n] * fastPow(denom, DIVIDE_NUM-2) % DIVIDE_NUM;
        System.out.println(ret);
    }

    public static long fastPow(long base, long exp) {
        long result = 1;
        while (exp > 0) {
            if (exp % 2 == 1) {
                result = (base * result) % DIVIDE_NUM;
            }
            base = (base * base) % DIVIDE_NUM;
            exp /= 2;
        }

        return result;
    }
}
