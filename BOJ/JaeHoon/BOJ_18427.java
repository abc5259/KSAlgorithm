package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_18427 {
    static int N,M,H;
    static int[][] arr;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        dp = new int[N][H+1];
        arr = new int[N][];
        for(int i=0; i<N; i++) {
            String[] temp = br.readLine().split(" ");
            arr[i] = new int[temp.length];
            for(int j=0; j<temp.length; j++) {
                arr[i][j] = Integer.parseInt(temp[j]);
            }
        }

        for(int i=0; i<arr[0].length; i++) {
            dp[0][arr[0][i]] = 1;
        }

        for(int i=0; i<N; i++) {
            dp[i][0] = 1;
        }

        for(int i=1; i<N; i++) {
            for(int j=1; j<=H; j++) {
                dp[i][j] = dp[i-1][j];

                for(int m=0; m<arr[i].length; m++) {
                    if(j - arr[i][m] < 0) continue;
                    dp[i][j] = (dp[i][j] + dp[i-1][j-arr[i][m]]) % 10007;
                }
            }
        }

        for(int i=0; i<N; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        System.out.println(dp[N-1][H]);
    }
}
