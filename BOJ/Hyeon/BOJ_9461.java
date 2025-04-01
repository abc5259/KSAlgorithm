package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int k = Integer.parseInt(br.readLine());
            if (k < 4) {
                System.out.println(1);
                break;
            }
            long[] dp = new long[k + 1];

            dp[1] = 1;
            dp[2] = 1;
            dp[3] = 1;
            for (int i = 4; i < dp.length; i++) {
                dp[i] = dp[i - 2] + dp[i - 3];
            }
            System.out.println(dp[k]);
        }
    }
}
// dp 를 통해서 dp 값이 -2 와 -3의 합을 가진다. 이를 점화식을 통하고
// 4보다 작은 3가지의 경우 1을 출력하고 리턴하고, 이외는 값들을 1로 초기화하고 점화식을 이용한다.
// long 범위를 인식해야하고, 여러 반복이 있기 때문에 continue 로 해야한다.