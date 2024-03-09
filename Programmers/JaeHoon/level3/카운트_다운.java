package Programmers.JaeHoon.level3;

public class 카운트_다운 {
    class Solution {
        public int[] solution(int target) {
            int[] answer = {};
            int[][] dp = new int[target+1][2];
            for(int i=1; i<=target; i++) {
                dp[i][0] = Integer.MAX_VALUE;
            }

            for(int i=1; i<=target; i++) {
                for(int j=1; j<=20; j++) {

                    if(i - 50 >= 0) {
                        if(dp[i][0] > dp[i-50][0] + 1) {
                            dp[i][0] = dp[i-50][0] + 1;
                            dp[i][1] = dp[i-50][1] + 1;
                        }
                        else if(dp[i][0] == dp[i-50][0] + 1) {
                            dp[i][1] = Math.max(dp[i][1], dp[i-50][1] + 1);
                        }
                    }

                    if(i - j >= 0) {
                        if(dp[i][0] > dp[i-j][0] + 1) {
                            dp[i][0] = dp[i-j][0] + 1;
                            dp[i][1] = dp[i-j][1] + 1;
                        }
                        else if(dp[i][0] == dp[i-j][0] + 1) {
                            dp[i][1] = Math.max(dp[i][1], dp[i-j][1] + 1);
                        }
                    }

                    if(i - 2*j >= 0) {
                        if(dp[i][0] > dp[i-2*j][0] + 1) {
                            dp[i][0] = dp[i-2*j][0] + 1;
                            dp[i][1] = dp[i-2*j][1];
                        }
                        else if(dp[i][0] == dp[i-2*j][0] + 1) {
                            dp[i][1] = Math.max(dp[i][1], dp[i-2*j][1]);
                        }
                    }

                    if(i - 3*j >= 0) {
                        if(dp[i][0] > dp[i-3*j][0] + 1) {
                            dp[i][0] = dp[i-3*j][0] + 1;
                            dp[i][1] = dp[i-3*j][1];
                        }
                        else if(dp[i][0] == dp[i-3*j][0] + 1) {
                            dp[i][1] = Math.max(dp[i][1], dp[i-3*j][1]);
                        }
                    }
                }
            }
            return new int[]{dp[target][0], dp[target][1]};
        }
    }
}
