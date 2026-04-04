package Programmers.GiSeok.lv3;

import java.util.*;

public class 정수_삼각형 {

    public int solution(int[][] triangle) {
        int answer = 0;
        int n = triangle.length;
        int[][] dp = new int[n][n];

        // 각 지점에서 이전껄 선택했거나, 안했거나 -> 경로가 아니므로 경우의 수 제외해도 댐
        dp[0][0] = triangle[0][0];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                // 이전 수를 선택 o
                if (j == 0) {
                    dp[i][j] = triangle[i][j] + dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(
                        triangle[i][j] + dp[i - 1][j],
                        triangle[i][j] + dp[i - 1][j - 1]
                    );
                }
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[n - 1][i]);
        }

        return max;
    }
}
