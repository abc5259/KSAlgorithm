package BOJ.Hyeon.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2502 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int D = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] dp = new int[D];

        dp[D - 1] = K;

        int A = 1;

        while (true) {
            dp[0] = A;
            for (int i = A; i < K; i++) {
                dp[1] = i;
                for (int j = 2; j < D - 1; j++) {
                    dp[j] = dp[j - 1] + dp[j - 2];
                }
                if (dp[D - 1] == dp[D - 2] + dp[D - 3]) {
                    System.out.println(dp[0]);
                    System.out.println(dp[1]);
                    return;
                }
            }
            A++;
        }
    }
}

// S1 떡 먹는 호랑이 DP
// 일단 고려해야될 점이 그냥 최종적인 DP[D-1] 의 값만 알고 있어서
// 바텀업 방식으로 구현해서 dp[0] + dp[1] 의 값을 브루트포스해서
// 찾아내어야 하고 그다음에 조건문을 걸어서
// dp[D-1] == dp[D-2] + dp[D-3] 해서 일치하는 값을 찾아서 해야한다.