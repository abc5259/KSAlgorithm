package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1890 {
    static int[][] map;
    static int N;
    static long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        dp = new long[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0] = 1;
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
//                if(dp[i][j] == 0) continue;
                if(i == N-1 && j == N-1) {
                    break;
                }

                if(i + map[i][j] < N) dp[i + map[i][j]][j] += dp[i][j];
                if(j + map[i][j] < N) dp[i][j+map[i][j]] += dp[i][j];
            }
        }

        System.out.println(dp[N-1][N-1]);
    }
}
