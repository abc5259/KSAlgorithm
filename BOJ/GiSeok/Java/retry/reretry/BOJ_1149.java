package BOJ.GiSeok.Java.retry.reretry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1149 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // rgb 거리에는 집이 n개
        // 인접한 집은 서로 다른 색이어야 함
        // 이전의 선택이 이번 선택에 영향을 주고,
        // i번째 집의 최적 비용은 i-1번째 집에서의 다른 색 최적값에 의존함 → 최적 부분 구조

        int n = Integer.parseInt(br.readLine());
        int[][] colors = new int[n][3];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            colors[i][0] = Integer.parseInt(st.nextToken());
            colors[i][1] = Integer.parseInt(st.nextToken());
            colors[i][2] = Integer.parseInt(st.nextToken());
        }

        // 내가 지금 파란색 칠할건데, 이전 집의 빨간색 칠했을때 최적값과 초록색 칠했을때 최적값 중 최소인거 고르면 댐
        int[][] dp = new int[n][3];
        dp[0][0] = colors[0][0];
        dp[0][1] = colors[0][1];
        dp[0][2] = colors[0][2];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.min(dp[i-1][1] + colors[i][0], dp[i-1][2] + colors[i][0]);
            dp[i][1] = Math.min(dp[i-1][0] + colors[i][1], dp[i-1][2] + colors[i][1]);
            dp[i][2] = Math.min(dp[i-1][0] + colors[i][2], dp[i-1][1] + colors[i][2]);
        }

        int min = dp[n-1][0];
        min = Math.min(dp[n-1][1], min);
        min = Math.min(dp[n-1][2], min);
        System.out.println(min);
    }
}
