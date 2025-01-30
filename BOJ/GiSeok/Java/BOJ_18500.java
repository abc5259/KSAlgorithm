/**
 * [G1 구현|그래프] 미네랄 2 - O, 01:05:25
 * 시도 2
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_18500 {

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static int[][] cave;
    static int[][] mark;
    static int r, c;

    static class Point {
        int y, x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        cave = new int[r+1][c];
        for (int i = r; i > 0; i--) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                if (line.charAt(j) == '.') cave[i][j] = 0;
                else cave[i][j] = 1;
            }
        }

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        boolean turn = true;
        for (int i = 0; i < n; i++) {
            mark = new int[r+1][c];
            int th = Integer.parseInt(st.nextToken());

            if (turn) {
                for (int x = 0; x < c; x++) if (cave[th][x] == 1) { cave[th][x] = 0; break; }
            } else {
                for (int x = c-1; x >= 0; x--) if (cave[th][x] == 1) { cave[th][x] = 0; break; }
            }
            turn = !turn;

            int numbering = 1;
            for (int x = 0; x < c; x++) {
                if (cave[1][x] != 0 && mark[1][x] == 0) dfs(1, x, numbering);
            }

            for (int y = 2; y <= r; y++) {
                for (int x = 0; x < c; x++) {
                    if (cave[y][x] != 0 && mark[y][x] == 0) {
                        dfs(y, x, ++numbering);
                    }
                }
            }

            if (numbering > 1) {
                for (int num = 2; num <= numbering; num++) {
                    ArrayDeque<Point> q = new ArrayDeque<>();
                    int finallyCnt = Integer.MAX_VALUE;
                    for (int y = 1; y <= r; y++) {
                        for (int x = 0; x < c; x++) {
                            if (mark[y][x] == num) {
                                q.add(new Point(y, x));
                                int cnt = 0;
                                for (int yy = y; yy >= 1; yy--) {
                                    if (cave[yy][x] == 0) cnt++;
                                    else if (cave[yy][x] == 1 && mark[yy][x] != num) break;
                                }
                                finallyCnt = Math.min(finallyCnt, cnt);
                            }
                        }
                    }

                    while (!q.isEmpty()) {
                        Point p = q.pop();

                        cave[p.y][p.x] = 0;
                        cave[p.y-finallyCnt][p.x] = 1;
                    }
                }
            }
        }

        for (int y = r; y > 0; y--) {
            for (int x = 0; x < c; x++) {
                System.out.print(cave[y][x] == 0 ? '.' : 'x');
            }
            System.out.println();
        }
    }

    private static void dfs(int y, int x, int num) {
        mark[y][x] = num;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny <= 0 || ny > r || nx < 0 || nx >= c) continue;
            if (cave[ny][nx] == 0 || mark[ny][nx] != 0) continue;

            dfs(ny, nx, num);
        }
    }
}

/*
7 5
.....
.xxx.
.xx..
..xxx
....x
.x..x
.xxxx
1
4
*/
