package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();
        String str3 = br.readLine();

        int len1 = str1.length();
        int len2 = str2.length();
        int len3 = str3.length();

        int[][][] dp = new int[len1 + 1][len2 + 1][len3 + 1];

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                for (int k = 1; k <= len3; k++) {
                    if ((str1.charAt(i - 1) == str2.charAt(j - 1)) && (str2.charAt(j - 1) == str3.charAt(k - 1))) {
                        dp[i][j][k] = dp[i - 1][j - 1][k - 1] + 1;
                    } else {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], Math.max(dp[i][j - 1][k], dp[i][j][k - 1]));
                    }
                }
            }
        }
        System.out.println(dp[len1][len2][len3]);
    }
}
// G4 LCS 3 DP
// 40분
// LCS 최장 공통 부분 수열 문제라서 DP 라고 외우듯이 기억하고있다
// 근데 3차원이라서 DP를 각 문자가 같은지에 대해서 DP로 연산하고 else 의경우 각자의 이전 최대값을 가져서 dp 값에 저장한다.