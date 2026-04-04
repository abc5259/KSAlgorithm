package Programmers.Hyeon.lv3;

public class 등굣길 {
    class Solution {
        final int MOD = 1_000_000_007;

        public int solution(int m, int n, int[][] puddles) {
            int[][] dp = new int[n + 1][m + 1];

            for (int[] row : puddles) {
                int x = row[0];
                int y = row[1];

                dp[y][x] = -1;
            }

            dp[1][1] = 1;

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (i == 1 && j == 1) {
                        continue;
                    }

                    if (dp[i][j] == -1) {
                        continue;
                    }

                    if (dp[i - 1][j] != -1) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][j]) % MOD;
                    }
                    if (dp[i][j - 1] != -1) {
                        dp[i][j] = (dp[i][j] + dp[i][j - 1]) % MOD;
                    }
                }
            }
            return dp[n][m] % MOD;
        }
    }
}
// lv3 등굣길 DP
// 30분
// 가장 기본적인 DP 바텀업 문제인데 10분만에 다 풀고 계쏙해서 예제에서 문제가 생겼다
// 나는 처음에 0행과 0열을 다 1로 초기화시키려했는데 웅덩이로 인해서 피해받는 것을 고려못했다
// 가중치가 같다고 생각했는데 아래와 오른쪽으로만 갈 수 있고 또 가짓수에 따라 가중치가 달라져서 BFS 는 아니라고 생각
// 그럼 DP 라고 판단.