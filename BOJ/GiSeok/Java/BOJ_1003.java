/*
BOJ - 1003 피보나치 함수

f(0) = 0           ---> 1 0
f(1) = 1           ---> 0 1
f(2) = f(1) + f(0) ---> 1 1
f(3) = f(2) + f(1) ---> 1 2
f(4) = f(3) + f(2) ---> 2 3
f(5) = f(4) + f(3) ---> 3 5
= f(i)가 호출하는 f(0), f(1) 횟수는 f(i-1), f(i-2)가 호출하는 f(0), f(1) 횟수의 합과 같다.
*/

package BOJ.GiSeok.Java;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BOJ_1003 {
    public static int[] fb_dp(int n) {
        int[][] dp = new int[n + 1][2];
        // dp[i][0] == fb(i)가 호출하는 fb(0)의 횟수
        // dp[i][1] == fb(i)가 호출하는 fb(1)의 횟수

        dp[0][0] = 1;
        dp[0][1] = 0;

        if (n != 0) {
            dp[1][0] = 0;
            dp[1][1] = 1;
        }

        for (int i = 2; i < n+1; i++) {
            dp[i][0] = dp[i-1][0] + dp[i-2][0];
            dp[i][1] = dp[i-1][1] + dp[i-2][1];
        }

        return dp[n];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            int[] count = fb_dp(num);
            System.out.println(count[0] + " " + count[1]);
        }
    }
}