package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1509 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int len = str.length();
        char[] pal = str.toCharArray();

        boolean[][] isPal = new boolean[len][len];

        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (i == j) {
                    isPal[i][j] = true;
                    continue;
                }

                if (pal[i] == pal[j]) {
                    if (Math.abs(i - j) == 1 || isPal[i + 1][j - 1]) {
                        isPal[i][j] = true;
                    }
                }
            }
        }
        int[] dp = new int[len];

        for (int i = 0; i < len; i++) {
            dp[i] = i + 1;
        }

        for (int i = 1; i < len; i++) {
            if (isPal[0][i]) {
                dp[i] = 1;
                continue;
            }

            for (int j = 1; j <= i; j++) {
                if (isPal[j][i]) {
                    dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                }
            }
        }
        System.out.println(dp[len - 1]);
    }
}
// G1 팰린드롬 분할 DP
// 팰린드롬 여부를 파악하는 2차원 배열 입력되는 문자열의 크기만큼을 만들어 둔다
// 이를 통해 i랑 j 가 같은 1개 길이 i랑 j의 절대값이 1인 2개 길이 그외에 pal 배열의 i 랑 j 가 같고
// 사이의 배열이 팰린드롬인 3이상의 팰린드롬일때 true 로 해서 여부를 잡은다음
// j를 1 부터 i 까지의 팰린드롬 여부를 파악하면서 값을 더해주고 최소값을 가져간다.