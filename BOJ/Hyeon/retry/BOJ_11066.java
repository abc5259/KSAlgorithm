package BOJ.Hyeon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11066 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        int[] arr;
        int[] sum;
        int[][] dp;

        while (T-- > 0) {
            int K = Integer.parseInt(br.readLine());

            arr = new int[K + 1];
            sum = new int[K + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= K; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                sum[i] = arr[i] + sum[i - 1];
            }

            dp = new int[K + 1][K + 1];

            for (int len = 2; len <= K; len++) {
                for (int l = 1; l <= K - len + 1; l++) {
                    int r = l + len - 1;
                    dp[l][r] = Integer.MAX_VALUE;

                    for (int i = l; i < r; i++) {
                        int cost = dp[l][i] + dp[i + 1][r] + sum[r] - sum[l - 1];
                        dp[l][r] = Math.min(dp[l][r], cost);
                    }
                }
            }
            sb.append(dp[1][K]).append("\n");
        }
        System.out.println(sb);
    }
}
// G3 파일 합치기 DP 복습 실패
// 2시간
// 걍 답없음 점화식도 못세우겠고 부분합인거도 늦게알고 문제의 이해도 오래걸림
// 무조건 연속한 두 챕터인데 이거에 대한 설명도 빈약함
// l부터 r 까지 파일을 하나로 합치는 비용은
// 왼쪽 덩어리를 만드는데 드는 비용 + 오늘쪽 비용 + 두 덩어리 합체 비용 현재 구간의 총합