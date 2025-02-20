package BOJ.Hyeon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1890 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];
        int[][] dp = new int[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = board[0][0];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int tmp = board[i][j];
                if (tmp + i >= 0 && tmp + i < N) {
                    dp[tmp + i][j] = board[i][j] + board[tmp + i][j];
                }
                if (tmp + j >= 0 && tmp + j < N) {

                }
            }
        }

        System.out.println();
    }
}
