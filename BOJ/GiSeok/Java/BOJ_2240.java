/**
 * 2240 - 자두나무 [실패|02:20:01]
 * 골드5, DP, 시도4
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2240 {
    // 시간제한 2초, 메모리제한 128MB
    static int T, W;
    static int[] tree;
    static int[][][] dp;

    static int go(int t, int h, int w) {

        if (t <= 0 || w < 0) return 0;
        if (dp[t][h][w] != -1) return dp[t][h][w];

        dp[t][h][w] = Math.max(go(t-1, h^1, w-1), go(t-1, h, w)) + (tree[t]-1 == h ? 1 : 0);
        return dp[t][h][w];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        tree = new int[T+1];
        tree[0] = 0;
        for (int i = 1; i <= T; i++) tree[i] = Integer.parseInt(br.readLine());

        dp = new int[T+1][2][W+1];
        // -1로 초기화 하지않으면 dp 값들이 0이 되는데,
        // 0으로 dp 값이 존재하는지 여부를 정해주면 아직 구하지 않은 경우의 수에 대해서 return dp[t][h][w];가 실행된다.
        for (int i = 0; i <= T; i++) {
            for (int j = 0; j < 2; j++) Arrays.fill(dp[i][j], -1);
        }

        System.out.println(Math.max(go(T, 0, W), go(T, 1, W-1)));
    }
}
