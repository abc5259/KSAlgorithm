package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] podo = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            podo[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[n + 1];

        if (n == 1) {
            dp[1] = podo[1];
        } else if (n == 2) {
            dp[2] = podo[2] + podo[1];
        } else {
            dp[1] = podo[1];
            dp[2] = podo[2] + podo[1];

            for (int i = 3; i <= n; i++) {
                dp[i] = Math.max(dp[i - 2] + podo[i], Math.max(podo[i] + dp[i - 3] + podo[i - 1], dp[i - 1]));
            }
        }
        System.out.println(dp[n]);
    }
}
// 한참이나 틀렸다.
// 조건이 3가지였는데 2가지만 비교했다. 2579와 유사한 문제였는데,
// 3가지의 값을 줄 때 dp[i-2] + podo[i] = 는 현재값 + 한칸 뛰고 그 앞에 값들
// dp[i-1] = 현재값 이전까지의 최고 연산
// 마지막으로는 dp[i-3] + podo[i-1] + podo[i] 이다. 4개의 수의 경우 6 10 13 9 일 때
// 6 + 13 + 9 거나 6 + 10 + 9 거나 10 + 13으로 3가지를 비교해야만 한다.
