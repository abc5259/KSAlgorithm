package BOJ.Hyeon.feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            int max = 0;
            int[][] dp = new int[2][N + 1];
            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= N; j++) {
                    dp[i][j] = Integer.parseInt(st.nextToken());
                    max = Math.max(max, dp[i][j]);
                }
            }

            for (int j = 2; j <= N; j++) {
                for (int i = 0; i < 2; i++) {
                    if (i == 0) {
                        dp[i][j] += Math.max(dp[i + 1][j - 2], dp[i + 1][j - 1]);
                    } else {
                        dp[i][j] += Math.max(dp[i + -1][j - 2], dp[i - 1][j - 1]);
                    }
                    max = Math.max(max, dp[i][j]);
                }
            }
            sb.append(max).append("\n");
        }
        System.out.println(sb);
    }
}

//S1 스티커 DP
// 점화식을 빠르게 판단했지만 구현하는데 오래걸렸다.
// 이를 좀더 연습이 필요한거 같다
// 테스트케이스 만들어서 제출해보고 반례 또한 해봐야겠다.
// DP는 메모이제이션 누적합과 연관되어서 하면된다.