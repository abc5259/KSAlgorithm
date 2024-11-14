/**
 * 1961. 숫자 배열 회전 (D2|구현) [O|00:10:07]
 */
package Swea.Giseok;

import java.io.*;
import java.util.*;

public class swea_1961 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(br.readLine());
            int[][] board = new int[n][n];
            String[] ret = new String[n];
            Arrays.fill(ret, "");

            for (int y = 0; y < n; y++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int x = 0; x < n; x++) board[y][x] = Integer.parseInt(st.nextToken());
            }

            int[][] copy = new int[n][n];
            for (int cnt = 0; cnt < 3; cnt++) {
                for (int y = 0; y < n; y++) {
                    String tmp = "";
                    for (int x = 0; x < n; x++) {
                        copy[y][x] = board[n - x - 1][y];
                        tmp += copy[y][x];
                    }
                    ret[y] += tmp + " ";
                }
                for (int i = 0; i < n; i++) {
                    System.arraycopy(copy[i], 0, board[i], 0, n);
                }
            }

            System.out.println("#" + t);
            for (int i = 0; i < n; i++) System.out.println(ret[i]);
        }
    }
}