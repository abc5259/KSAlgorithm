package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1238 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[][] dp = new int[N+1][N+1];

        for(int i=0; i<=N; i++) {
            Arrays.fill(dp[i], 10000000);
            dp[i][i] = 0;
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            dp[s][e] = t;
        }

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                if (dp[j][i] == 10000000)
                    continue;
                for(int k=1; k<=N; k++) {
                    dp[j][k] = Math.min(dp[j][k], dp[j][i] + dp[i][k]);
                }
            }
        }

        int max = 0;

        for(int i=1; i<=N; i++) {
            max = Math.max(dp[i][X] + dp[X][i], max);
        }

        System.out.println(max);
    }
}
