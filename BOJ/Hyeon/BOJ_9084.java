package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9084 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] coins = new int[N + 1];

            for (int i = 1; i <= N; i++) {
                coins[i] = Integer.parseInt(st.nextToken());
            }
            int M = Integer.parseInt(br.readLine());

            int[] dp = new int[M + 1];

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    if (j == coins[i]) {
                        dp[j]++;
                    } else if (j > coins[i]) {
                        dp[j] = dp[j] + dp[j - coins[i]];
                    }
                }
            }
            sb.append(dp[M]).append("\n");
        }
        System.out.println(sb);
    }
}
// G5 동전 DP
// 각 동전 별로 DP 반복횟수를 매긴다.
// 일단 1원부터 M원까지를 동전 별로 반복해서 갯수를 만든다음에 누적해서 연산하면된다.
// 근데 dp 반복문 내에 동전을 세는것과 동전 반복문 내에 dp를 넣는것에 대해서 고민이 있었다.
// 근데 동전을 크게 해야된다.