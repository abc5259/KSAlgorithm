/**
 * 00:51:54 G4
 */
package BOJ.GiSeok.Java.retry;

import java.util.*;
import java.io.*;

public class BOJ_14502 {

    /**
     * 3 <= N, M <= 8
     * 전체 벽 세우는 경우의 수는 N * M에서 순서 상관없이 3개를 뽑는 것 = 64C3 = 41664.
     * 바이러스 퍼지는 경우의 수 N * M = 8 * 8 = 64.
     * 안전 영역 검사 N * M = 8 * 8 = 64.
     * 41664 * 64 * 64 = 170,655,744 = 약 1억 7천
     * 시간 제한 2초!!! -> 약 2억 > 약 1억 7천!
     */

    private static int[][] map;
    private static boolean[][] visited;
    private static int n, m;

    private static Deque<Point> virus = new ArrayDeque<>();
    private static int[] dy = {-1, 1, 0, 0};
    private static int[] dx = {0, 0, -1, 1};

    private static int ans = 0;

    private static class Point {
        int x, y;

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

        map = new int[n][m];
        for (int y = 0; y < n; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < m; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
                if (map[y][x] == 2) virus.add(new Point(y, x));
            }
        }

        wall(0, 0, 0);
        System.out.println(ans);
    }

    private static void diffusion(Point point) {
        for (int i = 0; i < 4; i++) {
            int ny = point.y + dy[i];
            int nx = point.x + dx[i];

            if (ny >= n || nx >= m || ny < 0 || nx < 0) continue;
            if (map[ny][nx] == 1 || map[ny][nx] == 2) continue;
            if (visited[ny][nx]) continue;

            visited[ny][nx] = true;
            diffusion(new Point(ny, nx));
        }
    }

    private static void wall(int y, int x, int cnt) {
        if (cnt == 3) {
            visited = new boolean[n][m];
            for (Point p : virus) {
                diffusion(p);
            }

            int a = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == 0 && !visited[i][j]) a++;
                }
            }

            ans = Math.max(ans, a);
            return;
        }

        for (int i = y; i < n; i++) {
            for (int j = y != i ? 0 : x; j < m; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    wall(i, j, cnt+1);
                    map[i][j] = 0;
                }
            }
        }
    }
}
