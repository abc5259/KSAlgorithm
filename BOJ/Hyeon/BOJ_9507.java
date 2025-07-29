package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9507 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        long[] dp = new long[70];

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i <= 67; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3] + dp[i - 4];
        }

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append("\n");
        }
        System.out.print(sb);
    }
}

// S4 Generations of Tribbles DP
// 쉽게 풀었다 그냥
// 제약조건을 잘 찾아서 정하고 바텀업 방식으로 주어진 점화식 활용햇다
// t번 반복하는것에 대해서 if else 조건문을 세부적으로 반복문 내로 넣어주고 기존의
// dp 배열의 개수르 최대로 설정해서 한다.