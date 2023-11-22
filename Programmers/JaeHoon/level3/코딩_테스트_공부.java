package Programmers.JaeHoon.level3;

import java.util.*;
public class 코딩_테스트_공부 {

    class Solution {
        public int solution(int alp, int cop, int[][] problems) {
            int answer = 0;

            int maxAlp = 0;
            int maxCop = 0;
            for(int[] problem: problems) {
                maxAlp = Math.max(maxAlp, problem[0]);
                maxCop = Math.max(maxCop, problem[1]);
            }

            int[][] dp = new int[maxAlp+2][maxCop+2];

            for(int i=0; i<dp.length; i++) Arrays.fill(dp[i], 2000000000);

            if(alp >= maxAlp && cop >= maxCop) {
                return 0;
            }

            if(maxAlp < alp) alp = maxAlp;
            if(maxCop < cop) cop = maxCop;

            for(int i=0; i<=alp; i++) {
                for(int j=0; j<=cop; j++) {
                    dp[i][j] = 0;
                }
            }

            for(int i=alp; i<=maxAlp; i++) {
                for(int j=cop; j<=maxCop; j++) {

                    dp[i+1][j] = Math.min(dp[i][j] + 1, dp[i+1][j]);

                    dp[i][j+1] = Math.min(dp[i][j] + 1, dp[i][j+1]);

                    for(int[] problem: problems) {
                        if(i >= problem[0] && j >= problem[1]) {
                            int row = Math.min(i+problem[2], maxAlp);
                            int col = Math.min(j+problem[3], maxCop);
                            dp[row][col] =
                                    Math.min(dp[row][col], dp[i][j] + problem[4]);
                        }
                    }
                }
            }


            return dp[maxAlp][maxCop];
        }
    }
}
