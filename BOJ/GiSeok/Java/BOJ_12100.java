/**
 * 12100 - 2048 (Easy) [실패|02:00:58]
 * 골드1
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12100 {

    static int[][] map;
    static int n;
    static int ret = 0;

    static int[][] _rotate(int[][] m) {
        int[][] temp = new int[n][n];

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                temp[y][x] = m[n - x - 1][y];
            }
        }

        return temp;
    }

    static int[][] _move(int[][] m) {
        int[][] temp = new int[n][n];

        for (int y = 0; y < n; y++) {
            int c = -1, d = 0;

            for (int x = 0; x < n; x++) {
                if (m[y][x] == 0) continue;
                if (d == 1 && m[y][x] == temp[y][c]) { temp[y][c] *= 2; d = 0; }
                else { temp[y][++c] = m[y][x]; d = 1; }
            }

            for (c++; c <n; c++) temp[y][c] = 0;
        }

        return temp;
    }

    static void dfs(int[][] m, int here) {
        if (here == 5) {
            for (int y = 0; y < n; y++) {
                for (int x = 0; x < n; x++) {
                    ret = Math.max(m[y][x], ret);
                }
            }

            return;
        }

        for (int i = 0; i < 4; i++) {
            int[][] d = new int[n][n];
            for (int j = 0; j < n; j++) d[j] = m[j].clone();

            d = _move(d);
            dfs(d, here + 1);
            m = _rotate(m);
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }

        dfs(map, 0);
        System.out.println(ret);
    }
}
