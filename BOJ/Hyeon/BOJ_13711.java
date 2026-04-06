package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_13711 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();

        int len1 = str1.length();
        int len2 = str2.length();


        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println(dp[len1][len2]);
    }
}
// G5 한글 LCS DP
// 5분
// 쉽게 풀었다.
// 최장 부분 공통 수열은 일단 두개의 길이중 공통 부분이 있는지를 비교해서 가장 긴 길이를 구한다
// 그래서 비교할 대상을 행으로 잡고 비교를 또 열로 잡아서 2차원 DP로 만든다음에
// 만약 두 단어가 같다면 각각 두단어보다 앞의 단어끼리 비교했을 때의 길이를 가져와야하므로 1인덱스부터 시작
// 값이 안같을 경우 else 에서 최대값을 계속밀어서 dp 의 마지막 값이 최대값 선정