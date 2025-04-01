package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11727 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];

        dp[1] = 1;
        if (n == 1) {
            System.out.println(dp[n]);
            return;
        }

        dp[2] = 3;
        for (int i = 3; i < dp.length; i++) {
            dp[i] = ((dp[i - 1] % 10007) + (2 * dp[i - 2]) % 10007) % 10007;
        }
        System.out.println(dp[n]);
    }
}
//1. n = 1
//2. n = 3
//3. n = 5
//4. n = 11
//5. n = 21
//6. n = 43
//7. n = 85
//8. n = 171

// 5 * 2 + 11 = 21
// 3 * 2 + 5 = 11
// 1 * 2 + 3 = 5
// dp 문제로 이전 값 + 전전 값 *2 이다.
// 가짓수를 계산하고 해당 수들을 이용하여 점화식을 만든다.