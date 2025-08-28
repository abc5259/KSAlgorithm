package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_15989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int T = Integer.parseInt(br.readLine());
//        StringBuilder sb = new StringBuilder();
//
//        int[][] dp = new int[10001][4];
//        dp[1][1] = dp[2][1] = dp[2][2] = dp[3][1] = dp[3][2] = dp[3][3] = 1;
//
//        for (int i = 4; i < 10001; i++) {
//            dp[i][1] = dp[i - 1][1];  // 1가지
//            dp[i][2] = dp[i - 2][1] + dp[i - 2][2];  // 2가지
//            dp[i][3] = dp[i - 3][1] + dp[i - 3][2] + dp[i - 3][3]; // 3가지
//        }
//
//        while (T-- > 0) {
//            int N = Integer.parseInt(br.readLine());
//            sb.append(dp[N][1] + dp[N][2] + dp[N][3]).append("\n");
//        }
//
//        System.out.println(sb);

        int T = Integer.parseInt(br.readLine());

        int[] dp = new int[100_01];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for (int i = 4; i < 100_01; i++) {
            dp[i] = dp[i - 3] + i / 2 + 1;
        }

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append("\n");
        }
        System.out.print(sb);
    }
}

// G5 1,2,3 더하기 4 DP
// dp[i][j] 의 합이 i가 되도록 더할 때 마지막으로 더한 숫자가 j 인 경우 + 오름차순 유지
// 점화식 i를 만 때 마지막에 1을 더하니까 1로 끝나느건 항상 개수가 1개이다
// 2로 끝나는거는 i-2조합에 2를 더해야되니까 2앞에는 1이나 2이만 가능하다
// i를 만들때 3을 더하려면 i-3 만드는 조합에 +3인데 1,2,3 다 된다. 이게 1번 풀이

// 2번 풀이는dp 상태를 분석해서 dp 를 dp[i-3] + i/2 +1로 풀었다.