package Programmers.Hyeon.lv3;

public class 정수_삼각형 {
    class Solution {
        public int solution(int[][] triangle) {
            int l = triangle.length;

            int[][] dp = new int[l][l];

            int max = triangle[0][0];
            dp[0][0] = max;

            for (int i = 1; i < l; i++) {
                dp[i][0] = dp[i - 1][0] + triangle[i][0];
                dp[i][i] = dp[i - 1][i - 1] + triangle[i][i];
            }

            for (int i = 2; i < l; i++) {
                for (int j = 1; j < i; j++) {
                    dp[i][j] = triangle[i][j] + Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
                }
            }

            for (int i = 0; i < l; i++) {
                max = Math.max(max, dp[l - 1][i]);
            }
            return max;
        }
    }
}

// lv3 정수 삼각형 DP
// 20분
// 그냥 풀었다
// 원래라면 2개의 방향이 있어서 3차원으로 해서 하려 했는데 양쪽의 삼각형에 대해서는 1방향 밖에없어서
// 그냥 첫번째 반복문에는 양쪽의 삼각형 테두리의 값을 누적해서 더했고
// dp 배열의 값에 대해서 max 로 초기화 시킴 l 이 1이면 바로 나와야되니
// 그리고 2번재 반복문에서는 테두리의 내부값 즉 자기 레이어위층에 대해 i-1 j-1, i-1 j 에 대해서 최대값에 대해 누적합을 가지고
// dp 배열을 완성하고 마지막 l-1 행의 값들에 대해서 max 와 비교해서 반환