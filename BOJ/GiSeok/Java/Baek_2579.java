package BOJ.GiSeok.Java;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Baek_2579 {
    public static int inspect(int[] stairs, int n) {
        int[][] dp = new int[3][n + 1];
        // dp[0] == 연속되지 않은 이전 결과와의 합
        // dp[1] == 2칸 앞에서 가장 큰 값과의 합
        // dp[2] == 두 개의 결과 중 최댓값 저장
        dp[0][0] = 0;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = stairs[1];
        dp[2][1] = stairs[1];

        for (int i = 2; i < n + 1; i++) {
            dp[0][i] = dp[1][i-1] + stairs[i];
            dp[1][i] = Math.max(dp[1][i-2], dp[0][i-2]) + stairs[i];

            dp[2][i] = Math.max(dp[0][i], dp[1][i]);
        }

        return dp[2][n];

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int num;
        int[] stairs = new int[N+1];

        stairs[0] = 0;
        for (int i = 1; i <= N; i++) {
            num = Integer.parseInt(br.readLine());
            stairs[i] = num;
        }

        System.out.println(inspect(stairs, N));
    }
}