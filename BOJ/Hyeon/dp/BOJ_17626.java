package BOJ.Hyeon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_17626 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = i;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 2; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        System.out.println(dp[n]);
    }
}

// 걍 1부터 시작해서 50000까지의 수가 있을 때 이를 제곱수로 어떻게 나타내느냐?
// 1은 1개 2는 2개 3은 3개이지만 4는 2^2로 인해 1이 된다. 이를 통해서 해당 숫자 - 제곱수가 존재할 경우
// 4-2*2는 0이므로 0번인덱스의 0번 값에다가 +1을 더한것으로 점화식을 가진다.
// 예를들어 15일경우 15 - 3*3 = > 6번인덱스에 +1인데 6번인덱스는 또 2번 인덱스 + 1이다.
// 6번 == 2^2 + 1^2 + 1^2 3번이고 2번 인덱스는 1^2 + 1^2 인 2번이라서 메모이제이션으로 활용한다.