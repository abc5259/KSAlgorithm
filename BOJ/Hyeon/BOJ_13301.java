package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_13301 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] dp = new long[N + 1];
        dp[1] = 1;

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        System.out.print(dp[N] * 4 + dp[N - 1] * 2);
    }
}
// S5 타일 장식물
// 쉽게 풀었다 DP 바텀 업 방식으로 해서
// dp[0] 부터 시작해서 피보나치의 개념을 도입 그런데 범위가 80이라서 long 타입 사용하고
// 최종적인 직사각형의 둘레는 가장 최대의값 *4 이후 두번째로 큰 값의 * 2의 합이다.