/**
 * 2806. N-Queen(D3|구현) [O|00:20:00]
 * 시도1
 */
package Swea.Giseok;

import java.io.*;

public class swea_2806 {

    static int n;
    static int ret = 0;
    static int[][] board;

    static boolean isGood(int y, int x) {
        for (int i = y+1; i < n; i++) { if(board[i][x] == 1) return false; }
        for (int i = y-1; i >= 0; i--) { if(board[i][x] == 1) return false; }
        for (int i = x+1; i < n; i++) { if(board[y][i] == 1) return false; }
        for (int i = x-1; i >= 0; i--) { if(board[y][i] == 1) return false; }

        int i = y + 1; int j = x + 1;
        for (; i < n && j < n; i++, j++) { if (board[i][j] == 1) return false; }
        i = y + 1; j = x - 1;
        for (; i < n && j >= 0; i++, j--) { if (board[i][j] == 1) return false; }
        i = y - 1; j = x + 1;
        for (; i >= 0 && j < n; i--, j++) { if (board[i][j] == 1) return false; }
        i = y - 1; j = x - 1;
        for (; i >= 0 && j >= 0; i--, j--) { if (board[i][j] == 1) return false; }

        return true;
    }

    static void go(int y, int x, int q) {

        if (q == n) {
            ret++;
            return;
        }

        for (int i = y; i < n; i++) {
            for (int j = (y == i) ? x : 0; j < n; j++) {
                if (isGood(i, j)) {
                    board[i][j] = 1;
                    go(i, j+1, q+1);
                    board[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            n = Integer.parseInt(br.readLine());
            board = new int[n][n];
            ret = 0;

            go(0, 0, 0);
            System.out.println("#" + tc + " " + ret);
        }
    }
}