package Programmers.JaeHoon.level2;

import java.util.*;

public class 에어컨 {
    class Solution {
        public int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {
            int k = 1000 * 100;
            int answer = Integer.MAX_VALUE;
            int N = onboard.length;
            int[][] dp = new int[N][51];
            for (int i = 0; i < onboard.length; i++) {
                for (int j = 0; j < 51; j++) {
                    dp[i][j] = k;
                }
            }
            if(t2 < temperature) {
                //온도를 내려야함
                dp[0][temperature+10] = 0;

                for(int i=1; i<N; i++) {
                    for(int j=0; j<=50; j++) {
                        int min =  Integer.MAX_VALUE - 1000;
                        if(onboard[i] == 0 || (onboard[i] == 1 && j >= t1+10 && j <= t2+10)) {

                            if(j-1 >= 0)
                                min = Math.min(min,dp[i-1][j-1]);

                            if(j == temperature+10)
                                min = Math.min(min,dp[i-1][j]);

                            if(j+1 <= 50)
                                min = Math.min(min,dp[i-1][j+1]+a);

                            if(t1+10 <= j && j <= t2+10)
                                min = Math.min(min,dp[i-1][j]+b);

                            dp[i][j] = min;
                        }
                    }
                }
            }else {
                dp[0][temperature+10] = 0;
                for(int i=1; i<N; i++) {
                    for(int j=0; j<=50; j++) {
                        int min =  k;
                        if(onboard[i] == 0 || (onboard[i] == 1 && j >= t1+10 && j <= t2+10)) {

                            if(j+1 <= 50)
                                min = Math.min(min,dp[i-1][j+1]);

                            if(j == temperature+10)
                                min = Math.min(min,dp[i-1][j]);

                            if(j-1 >= 0)
                                min = Math.min(min,dp[i-1][j-1]+a);

                            if(t1+10 <= j && j <= t2+10)
                                min = Math.min(min,dp[i-1][j]+b);

                            dp[i][j] = min;
                        }
                    }
                }
            }

            answer = dp[N-1][0];
            for(int i=0; i<=50; i++) {
                answer = Math.min(dp[N-1][i],answer);
            }
            return answer;
        }
    }
}
