package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2666 {
    static int[] arr;
    static int N,M;
    static int[][][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        int[] open = new int[2];
        st = new StringTokenizer(br.readLine());
        open[0] = Integer.parseInt(st.nextToken());
        open[1] = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(br.readLine());
        arr = new int[M];
        dp = new int[M][N+1][N+1];
        for(int i=0; i<M; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < M; i++) {
            for (int j = 1; j <= N; j++) // (n은 1부터)
                Arrays.fill(dp[i][j], -1); // 초기 값은 -1로 초기화
        }

        System.out.println(solve(0, open[0], open[1]));
    }

    public static int solve(int depth, int left, int right) {
        if(depth == M) {
            return 0;
        }

        if(dp[depth][left][right] != -1) {
            return dp[depth][left][right];
        }

        int temp1 = Math.abs(left - arr[depth]);
        int temp2 = Math.abs(right - arr[depth]);

        return dp[depth][left][right] = Math.min(
                temp1 + solve(depth+1, arr[depth], right),
                temp2 + solve(depth+1, left, arr[depth]));
    }
}
