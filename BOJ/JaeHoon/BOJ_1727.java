package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1727 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] menArr = new int[N+1];
        int[] girlArr = new int[M+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            menArr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=M; i++) {
            girlArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(menArr);
        Arrays.sort(girlArr);
        int[][] dp = new int[N+1][M+1];

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=M; j++) {
                if(i == j) {
                    dp[i][j] = dp[i-1][j-1] + Math.abs(menArr[i] - girlArr[j]);
                }
                else if(i > j) {
                    dp[i][j] = Math.min(dp[i-1][j],dp[i-1][j-1] + Math.abs(menArr[i] - girlArr[j]));
                }
                else if(i < j) {
                    dp[i][j] = Math.min(dp[i][j-1],dp[i-1][j-1] + Math.abs(menArr[i] - girlArr[j]));
                }
            }
        }
        System.out.println(dp[N][M]);
    }
}
