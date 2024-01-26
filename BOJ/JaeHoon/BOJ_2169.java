package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2169 {
    static int N,M;
    static int[][] map;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dp = new int[N][M];
        int[][] temp1 = new int[N][M];
        int[][] temp2 = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = map[0][0];
        for(int i=1; i<M; i++) {
            dp[0][i] = dp[0][i-1] + map[0][i];
        }

        for(int i=1; i<N; i++) {

            temp1[i][0] = dp[i-1][0] + map[i][0];
            for(int j=1; j<M; j++) {
                temp1[i][j] = Math.max(dp[i-1][j], temp1[i][j-1]) + map[i][j];
            }

            temp2[i][M-1] = dp[i-1][M-1] + map[i][M-1];
            for(int j=M-2; j>=0; j--) {
                temp2[i][j] = Math.max(dp[i-1][j], temp2[i][j+1]) + map[i][j];
            }

            for(int j=0; j<M; j++) {
                dp[i][j] = Math.max(temp1[i][j], temp2[i][j]);
            }
        }

        System.out.println(dp[N-1][M-1]);


    }
}
