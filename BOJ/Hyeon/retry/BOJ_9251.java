package BOJ.Hyeon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] str1 = br.readLine().toCharArray();
        char[] str2 = br.readLine().toCharArray();

        int[][] dp = new int[str1.length + 1][str2.length + 1];


        for (int i = 1; i <= str1.length; i++) {
            for (int j = 1; j <= str2.length; j++) {
                if (str1[i - 1] == str2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println(dp[str1.length][str2.length]);
    }
}

// G5 LCS DP
// 최장 공통 부분 수열 문제
// 두 수열이 주어졌을 때 공통 부분을 구하는건데 DP 를 수열로 관리하는 그리드 형태의 DP를 구현해서
// 점화식 형태를 추출하면된다 만약 문자가 같을 때는 -1, -1 방향의 대각선 값에서 공통 수열이 추가된거라서 +1 해주면되고
// 다른 문자일 경우 현재 dp 자리에서 이전의 행과 열의 값중 가장 큰거를 가지고와서 저장한다
// 이때까지 반영된 숫자는 가지고있어야 하기 때문
