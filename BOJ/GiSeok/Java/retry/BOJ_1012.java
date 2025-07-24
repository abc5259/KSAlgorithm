/**
 * 00:10:16 S2
 */
package BOJ.GiSeok.Java.retry;

import java.util.*;
import java.io.*;

public class BOJ_1012 {
    private final static int[] dy = {-1, 1, 0, 0};
    private final static int[] dx = {0, 0, -1, 1};

    private static int[][] farm;
    private static boolean[][] visited;
    private static int n, m;

    private static class point {
        int y, x;

        public point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for (int tt = 0; tt < t; tt++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            farm = new int[n][m];
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                farm[y][x] = 1;
            }

            int ans = 0;
            visited = new boolean[n][m];
            for (int y = 0; y < n; y++) {
                for (int x = 0; x < m; x++) {
                    if (farm[y][x] == 1 && !visited[y][x]) {
                        dfs(new point(y, x));
                        ans++;
                    }
                }
            }

            System.out.println(ans);
        }
    }

    private static void dfs(point p) {
        for (int i = 0; i < 4; i++) {
            int ny = p.y + dy[i];
            int nx = p.x + dx[i];

            if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
            if (visited[ny][nx]) continue;
            if (farm[ny][nx] == 0) continue;

            visited[ny][nx] = true;
            dfs(new point(ny, nx));
        }
    }
}
