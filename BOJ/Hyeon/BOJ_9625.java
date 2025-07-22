package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9625 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        int[][] dp = new int[K + 1][2];

        dp[0][0] = 1;
        dp[1][1] = 1;

        for (int i = 2; i <= K; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
            dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
        }

        System.out.print(dp[K][0] + " " + dp[K][1]);
    }
}

// S5 BABBA DP
// 금방 풀었음 string으로 접근했을 때 heap 초과하는 배열문제그런데
// 래퍼타입이기도하고 계속 생성하는 힙메모리 특성상 제한이 걸릴 거 같아서 확인삼아 했다.