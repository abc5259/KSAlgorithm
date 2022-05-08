/*
BaekJoon - 11726 2xN 타일링 2 (05/08 일)

*/
package BOJ.GiSeok;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Baek_11727 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+4];

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 3;
        dp[3] = 5;

        for (int i = 4; i < N+1; i++) {
            dp[i] = ((dp[i-1]*2-dp[i-2]) + (dp[i-4]*4)) % 10007;
        }

        System.out.println(dp[N]);
    }
}