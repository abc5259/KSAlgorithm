package BOJ.Hyeon.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17404 {
    static int MAX = 1_000_001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] house = new int[N + 1][3];
        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                house[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[N + 1][3];
        int res = MAX;

        for (int i = 0; i < 3; i++) {
            for (int c = 0; c < 3; c++) {
                if (c == i) {
                    dp[1][c] = house[1][c];
                } else {
                    dp[1][c] = MAX;
                }
            }

            for (int j = 2; j <= N; j++) {
                dp[j][0] = Math.min(dp[j - 1][1], dp[j - 1][2]) + house[j][0];
                dp[j][1] = Math.min(dp[j - 1][0], dp[j - 1][2]) + house[j][1];
                dp[j][2] = Math.min(dp[j - 1][0], dp[j - 1][1]) + house[j][2];
            }

            for (int j = 0; j < 3; j++) {
                if (j != i) {
                    res = Math.min(res, dp[N][j]);
                }
            }
        }
        System.out.println(res);

    }
}

// G4 RGB 거리 2 DP
// retry 점화식 추출 필요