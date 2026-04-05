package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5582 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();

        int len1 = str1.length();
        int len2 = str2.length();

        int[][] dp = new int[len1 + 1][len2 + 1];

        int max = 0;

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(max, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        System.out.println(max);
    }
}
// G5 공통 부분 문자열 DP
// 6분
// 일단 풀었다.
// 최장 공통 부분 수열 문제를 풀다가 다른 스타일을 발견함 이는 무조건 연속된 문자열이 중복으로 있어야 하기에
// 각 단어별로 비교하였을 때 다르다면 이전의 dp 누적값이 아닌 새롭게 0을 가지고 시작하여 연속성을 지켜준다