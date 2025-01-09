/**
 * [G3 BFS] 1600 - O(반례힌트), 00:58:16
 * 시도4
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_1600 {

    private static class Point {
        int x, y, move, k;

        public Point(int y, int x, int move, int k) {
            this.x = x;
            this.y = y;
            this.move = move;
            this.k = k;
        }
    }

    private static int[] dy = {-1, 1, 0, 0};
    private static int[] dx = {0, 0, -1, 1};
    private static int[][] knightMove = {{-2, -1}, {-1, -2}, {1, -2}, {2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[][] map = new int[h][w];
        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }

        boolean[][][] visited = new boolean[h][w][k+1];

        ArrayDeque<Point> q = new ArrayDeque<>();
        q.add(new Point(0, 0, 0, k));
        visited[0][0][k] = true;

        while (!q.isEmpty()) {
            Point p = q.poll();

            if (p.x == w - 1 && p.y == h - 1) {
                System.out.println(p.move);
                return;
            }

            if (p.k > 0) {
                for (int i = 0; i < 8; i++) {
                    int kny = p.y + knightMove[i][0];
                    int knx = p.x + knightMove[i][1];

                    if (kny < 0 || kny >= h || knx < 0 || knx >= w) continue;
                    if (map[kny][knx] != 0) continue;
                    if (visited[kny][knx][p.k - 1]) continue;

                    q.add(new Point(kny, knx, p.move + 1, p.k - 1));
                    visited[kny][knx][p.k - 1] = true;
                }
            }

            for (int i = 0; i < 4; i ++) {
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];

                if (ny < 0 || ny >= h || nx < 0 || nx >= w) continue;
                if (map[ny][nx] != 0) continue;
                if (visited[ny][nx][p.k]) continue;

                q.add(new Point(ny, nx, p.move + 1, p.k));
                visited[ny][nx][p.k] = true;
            }
        }

        System.out.println(-1);
    }
}
