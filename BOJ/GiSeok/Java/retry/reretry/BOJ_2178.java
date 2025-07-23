package BOJ.GiSeok.Java.retry.reretry;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 00:54:33 S1
 * 2 <= N, M <= 100
 * 100 * 100 = 10000
 */

public class BOJ_2178 {
    private static int[] dy = {-1, 1, 0, 0};
    private static int[] dx = {0, 0, -1, 1};

    private static int[][] map;
    private static int n, m;

    private static class point {
        int y, x;

        public point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int y = 0; y < n; y++) {
            String s = br.readLine();
            for (int x = 0; x < m; x++) {
                map[y][x] = s.charAt(x) - '0';
            }
        }

        int ans = 0;

        Deque<point> queue = new ArrayDeque<>();
        queue.add(new point(0, 0));
        while (!queue.isEmpty()) {
            point p = queue.poll();

            for (int i = 0; i < 4; i++) {
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];

                if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                if (ny == n-1 && nx == m-1) {
                    System.out.println(map[p.y][p.x] + 1);
                    System.exit(0);
                }
                if (map[ny][nx] != 1) continue;

                map[ny][nx] = map[p.y][p.x] + 1;
                queue.add(new point(ny, nx));
            }
        }
    }
}
