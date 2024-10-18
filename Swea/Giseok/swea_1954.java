/**
 * 1954. 달팽이 숫자 (D2|구현) [O|00:46:09]
 * 시도1
 */
package Swea.Giseok;

import java.io.*;

public class swea_1954 {
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            int n = Integer.parseInt(br.readLine());
            int[][] snail = new int[n][n];

            int dir = 0;
            int y = 0, x = 0;
            for (int i = 1; i <= n*n; i++) {
                snail[y][x] = i;

                int ny = y + dy[dir];
                int nx = x + dx[dir];

                if (ny < 0 || ny >= n || nx < 0 || nx >= n || snail[ny][nx] != 0) {
                    dir = (dir + 1) % 4;
                    ny = y + dy[dir];
                    nx = x + dx[dir];
                }

                y = ny;
                x = nx;
            }

            System.out.println("#" + tc);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(snail[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}