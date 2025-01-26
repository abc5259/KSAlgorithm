package BOJ.Hyeon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11726 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < dp.length; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
        }
        System.out.println(dp[n]);
    }
}
// 앞의 과정을 그대로 사용하기 때문에 바텀업을 통해서 앞 두수의 합을 가지는 dp를 만든다.
// 10007나머지로 값을 출력하고, 타일의 경우 이전 값을 받는다.
// 처음에는 dp를 1001개로 고정하였으나 입력값에 따라 만들 수 있어서 수정하였다.