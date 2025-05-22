package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11051 {
    static final int MOD = 10_007;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        dp = new int[n + 1][k + 1];

        System.out.println(cal(n, k));
    }

    static int cal(int n, int k) {
        if (n == k || k == 0) {
            return dp[n][k] = 1;
        }
        if (dp[n][k] > 0) {
            return dp[n][k];
        }
        return dp[n][k] = (cal(n - 1, k - 1) + cal(n - 1, k)) % MOD;
    }
}
// S1 이항 계수2 DP
// 파스칼 삼각형의 n+1Cr+1 = nCr + nCr+1 을 이용해서 DP에다가 적용했다
// 먼저 조합을 다루는 이항계수이기에 N! / R! * (N-R)! 계산을 해야하는데 이때 값을 구하는
// 파스칼 삼각현을 통해서 DP를 이용했다 DP가 값을 가지고 잇을경우 O(1)로 접근간으하고
// cal 재귀를 통해 dp 값을 대입해준다
// dp는 [n+1][k+1] 까지 해서 [n][k] = [n-1][k-1]+[n-1][k] 이값으로 연산하고 MOD 연산해주면된다.