package BOJ.Hyeon.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_13852 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        int[] dp = new int[N + 1];
        int[] str = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            dp[i] = dp[i - 1] + 1;
            str[i] = i - 1;
            if (i % 2 == 0 && dp[i] > dp[i / 2] + 1) {
                dp[i] = dp[i / 2] + 1;
                str[i] = i / 2;
            }
            if (i % 3 == 0 && dp[i] > dp[i / 3] + 1) {
                dp[i] = dp[i / 3] + 1;
                str[i] = i / 3;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(dp[N] - 1).append("\n");

        while (N > 0) {
            sb.append(N).append(" ");
            N = str[N];
        }
        System.out.println(sb);
    }
}

// S1 1로 만들기 2 DP
// 일단 어찌저찌 풀었다. dp 처럼 한게 맞나 싶기도하고