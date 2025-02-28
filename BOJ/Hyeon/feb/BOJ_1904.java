package BOJ.Hyeon.feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];
        dp[0] = dp[1] = 1;

        for (int i = 2; i < dp.length; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 15746;
        }
        System.out.println(dp[N]);
    }
}
// 개 쉽게 풀었다 이거는 그냥 최근에 DP 타일문제를 많이 풀어보기도 했고
// 점화식도 발견이 빨랐으며, 메모이제이션을 잘 활용했다.
