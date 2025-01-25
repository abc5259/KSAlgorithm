package BOJ.Hyeon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());

        int[] dp = new int[X + 1];

        for (int i = 2; i <= X; i++) {
            dp[i] = dp[i - 1] + 1;
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }
        System.out.println(dp[X]);
    }
}
//dp 제출
// dp[0] 은 제외하고 입력값이 1부터 시작하여 입력값 +1의 dp를 생성한다.
// 이후 dp[1] 이 0이고 2부터 최적값을 구해갈 때 이전값을 활용하여 구하거나
// 혹은 더 나은 방안이 있을 때도 있어서 이를 잘 활용하여
// dp[입력값] 이 최소가 되어야 한다. Math.min을 통해 반복하여 한다.