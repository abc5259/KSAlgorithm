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
        dp[1] = podo[1];

        if (n > 1) {
            dp[2] = podo[2] + podo[1];
        }

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], podo[i] + Math.max(dp[i - 3] + podo[i - 1], dp[i - 2]));
        }
        System.out.print(dp[n]);
    }
}

// S1 포도주 시식 DP
// 3가지 연속이 안된다 이거는 DP와 기존 배열을 비교해서 구분해야 된다
// 이번에 안먹는다면 저번까지의 최대 vs 이번에 먹으면 이전꺼 먹고 먹은건지 아닌지 비교해야된다.
// 이번꺼 먹고 이전꺼 먹었으면 그전꺼먹으면 안돼서 그전의 DP를 먹고
// 이번꺼 먹고 이전꺼 안먹었으면 그전까지의 DP를 계산해서 비교한다.