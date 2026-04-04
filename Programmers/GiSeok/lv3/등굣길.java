package Programmers.GiSeok.lv3;

import java.util.*;

public class 등굣길 {

    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < puddles.length; i++) {
            dp[puddles[i][1]][puddles[i][0]] = -1;
        }

        dp[1][1] = 1;
        for (int y = 1; y <= n; y++) {
            for (int x = 1; x <= m; x++) {
                if (dp[y][x] == -1 || (y == 1 && x == 1)) {
                    continue;
                }

                int up = (dp[y - 1][x] == -1) ? 0 : dp[y - 1][x];
                int left = (dp[y][x - 1] == -1) ? 0 : dp[y][x - 1];

                dp[y][x] = (up + left) % 1000000007;
            }
        }

        return dp[n][m];
    }
}
