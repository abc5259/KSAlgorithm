/**
 * [G3 BFS] 치즈 - O, 01:16:04
 * 시도 5
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_2638 {

    private static final int[] dy = {-1, 1, 0, 0};
    private static final int[] dx = {0, 0, -1, 1};

    private static int[][] table;
    private static int n, m;

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

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        table = new int[n][m];
        for (int y = 0; y < n; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < m; x++) {
                table[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        int day = 0;
        int check = 2;
        while (true) {
            bfs(check);
            if (!isCheeseAlive()) break;

            for (int y = 0; y < n; y++) {
                for (int x = 0; x < m; x++) {
                    if (table[y][x] == 1) {
                        int airCount = 0;
                        for (int i = 0; i < 4; i++) {
                            int ny = y + dy[i];
                            int nx = x + dx[i];

                            if (ny < 0 || ny >= n || nx < 0 || nx >= m)
                                continue;

                            if (table[ny][nx] == check)
                                airCount++;
                        }

                        if (airCount >= 2) table[y][x] = 0;
                    }
                }
            }

            day++;
            check++;
        }

        System.out.println(day);
    }

    private static void bfs(int check) {
        ArrayDeque<Point> q = new ArrayDeque<>();
        q.add(new Point(0, 0));
        table[0][0] = check;

        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int i = 0; i < 4; i++) {
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];

                if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                if (table[ny][nx] == 1 || table[ny][nx] == check) continue;

                q.add(new Point(ny, nx));
                table[ny][nx] = check;
            }
        }
    }

    private static boolean isCheeseAlive() {
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                if (table[y][x] == 1) return true;
            }
        }

        return false;
    }
}
