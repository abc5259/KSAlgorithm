package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1398 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] dp = new int[100]; // 1 ~ 99
        for (int i = 0; i < 100; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[1] = 1;
        dp[10] = 1;
        dp[25] = 1;

        for (int i = 2; i <= 99; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.min(dp[i], dp[j] + dp[i - j]);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int answer = 0;
            long price = Long.parseLong(br.readLine());

            while (price > 0) {
                int length = String.valueOf(price).length();
                if (length % 2 == 0) {
                    //짝수라면
                    int td = (int) (price / (long) Math.pow(10, length - 2)); //앞 두 자리
                    answer += dp[td];
                    price -= (td * (long) Math.pow(10, length - 2));
                } else {
                    //홀수라면
                    int od = (int) (price / (long) Math.pow(10, length - 1)); //앞 한 자리
                    answer += dp[od];
                    price -= (od * (long) Math.pow(10, length - 1));
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.print(sb);
    }
}
