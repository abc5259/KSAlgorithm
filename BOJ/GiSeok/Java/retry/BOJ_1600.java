/**
 * [G3 BFS] 말이 되고픈 원숭이 - O, 00:38:13
 * 시도 5
 */
package BOJ.GiSeok.Java.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1600 {

    static class Point {
        int y, x, k;

        public Point(int y, int x, int k) {
            this.y = y;
            this.x = x;
            this.k = k;
        }
    }

    private static final int[] dy = {-1, 1, 0, 0};
    private static final int[] dx = {0, 0, -1, 1};

    private static final int[] hy = {-2, -1, 1, 2, 2, 1, -1, -2};
    private static final int[] hx = {-1, -2, -2, -1, 1, 2, 2, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[][] map = new int[h][w];
        for (int y = 0; y < h; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < w; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        int[][][] visited = new int[h][w][k+1];
        for (int y = 0; y < h; y++)
            for (int x = 0; x < w; x++) Arrays.fill(visited[y][x], 987654321);

        ArrayDeque<Point> q = new ArrayDeque<>();
        q.add(new Point(0, 0, k));
        visited[0][0][k] = 0;

        while (!q.isEmpty()) {
            Point p = q.poll();

            if (p.k > 0) {
                for (int i = 0; i < 8; i++) {
                    int ny = p.y + hy[i];
                    int nx = p.x + hx[i];

                    if (ny < 0 || ny >= h || nx < 0 || nx >= w) continue;
                    if (visited[ny][nx][p.k - 1] <= visited[p.y][p.x][p.k] + 1) continue;
                    if (map[ny][nx] == 1) continue;

                    visited[ny][nx][p.k - 1] = visited[p.y][p.x][p.k] + 1;
                    q.add(new Point(ny, nx, p.k - 1));
                }
            }

            for (int i = 0; i < 4; i++) {
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];

                if (ny < 0 || ny >= h || nx < 0 || nx >= w) continue;
                if (visited[ny][nx][p.k] <= visited[p.y][p.x][p.k] + 1) continue;
                if (map[ny][nx] == 1) continue;

                visited[ny][nx][p.k] = visited[p.y][p.x][p.k] + 1;
                q.add(new Point(ny, nx, p.k));
            }
        }

        int ret = visited[h-1][w-1][k];
        for (int i = 0; i < k; i++) ret = Math.min(ret, visited[h-1][w-1][i]);
        System.out.println(ret == 987654321 ? -1 : ret);
    }
}
