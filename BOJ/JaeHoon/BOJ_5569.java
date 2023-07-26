package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_5569 {
    static boolean[][] isVisit;
    static int[] dx = {-1,0}; //북, 동
    static int[] dy = {0,1};
    static int W,H;
    static long answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());


        //row, col, 방향, 교차로 여부
        int[][][][] dp = new int[W+1][H+1][2][2];

        for(int i=1; i<=W; i++) {
            dp[i][1][0][0] = 1;
        }
        for(int i=1; i<=H; i++) {
            dp[1][i][1][0] = 1;
        }

        for(int row=2; row<=W; row++) {
            for(int col=2; col<=H; col++) {

                dp[row][col][0][0] = (dp[row-1][col][0][0] + dp[row-1][col][0][1]) % 100000;
                dp[row][col][0][1] = dp[row-1][col][1][0];
                dp[row][col][1][0] = (dp[row][col-1][1][0] + dp[row][col-1][1][1]) % 100000;
                dp[row][col][1][1] = dp[row][col-1][0][0];
            }
        }
        int result = (dp[W][H][0][0] + dp[W][H][0][1] + dp[W][H][1][0] + dp[W][H][1][1]) % 100000;
        System.out.println(result);
    }

}
