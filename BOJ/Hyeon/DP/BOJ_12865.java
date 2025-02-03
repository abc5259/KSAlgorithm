package BOJ.Hyeon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] weight = new int[N + 1];
        int[] value = new int[N + 1];

        int[][] dp = new int[N + 1][K + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                if (weight[i] > j) {
                    dp[i][j] = dp[i - 1][j];// 배낭에 더 넣지 못할 때 이전까지 넣었던 가장 큰 무게를 넣어준다.
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                    // 현재 물건의 무게가 배낭 용량 보다 작거나 같을 때, 즉 배낭에 새롭게 넣을 수 있을 때
                    // 배낭의 이전값과 비교한다. 지금 배낭에 넣을 수 있는 값 + 지금 배낭넣고 남는 공간에 들어갈 수 있는 짐의 이전 값
                    // 남은 공간에서 얻을 수 있는 최대 가치는 이미 이전 단계에서 계산된 값인 에 저장되어 있습니다.
                }
            }
        }
        System.out.println(dp[N][K]);
    }
}
