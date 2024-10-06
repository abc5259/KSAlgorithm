/**
 * 1767. [SW Test 샘플문제] 프로세서 연결하기(완탐) [O|01:18:30]
 * 시도5
 */
package Swea.Giseok;

import java.io.*;
import java.util.*;

public class swea_1767 {

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static ArrayList<Pair> corelist;
    static int[][] cell;
    static int n;
    static int max, ret;

    static class Pair {
        int y, x;
        public Pair(int y, int x) { this.y = y; this.x = x; }
    }

    static boolean check(int y, int x, int idx, int[][] m) {
        int ny = y;
        int nx = x;
        while (true) {
            ny = ny + dy[idx];
            nx = nx + dx[idx];

            if (ny < 0 || nx < 0 || ny >= n || nx >= n) break;
            if (m[ny][nx] == 1 || m[ny][nx] == 9) return false;
        }

        return true;
    }

    static void go(int idx, int core, int sum, int[][] m) {

        if (idx == corelist.size()) {
            if (max < core) {
                max = core;
                ret = sum;
            } else if (max == core) {
                ret = Math.min(sum, ret);
            }

            return;
        }

        Pair p = corelist.get(idx);
        for (int i = 0; i < 4; i++) {
            if (check(p.y, p.x, i, m)) {

                int cnt = 0;
                int ny = p.y;
                int nx = p.x;
                while (true) {
                    ny = ny + dy[i];
                    nx = nx + dx[i];

                    if (ny < 0 || nx < 0 || ny >= n || nx >= n) break;
                    m[ny][nx] = 9;
                    cnt++;
                }

                go(idx + 1, core + 1, sum + cnt, m);

                ny = p.y;
                nx = p.x;
                while (true) {
                    ny = ny + dy[i];
                    nx = nx + dx[i];

                    if (ny < 0 || nx < 0 || ny >= n || nx >= n) break;
                    m[ny][nx] = 0;
                }
            }
        }
        go(idx + 1, core, sum, m);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {

            n = Integer.parseInt(br.readLine());
            corelist = new ArrayList<>();
            cell = new int[n][n];

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    cell[i][j] = Integer.parseInt(st.nextToken());
                    if (cell[i][j] == 1) corelist.add(new Pair(i, j));
                }
            }
            ret = 987654321;
            max = 0;
            go(0, 0, 0, cell);
            System.out.println("#" + tc + " " + ret);
        }
    }
}
