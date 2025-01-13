/**
 * [G4 다익스트라] 알고스팟 - O, 00:49:51
 * 시도2
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1261 {
    private static int[] dy = {-1, 1, 0, 0};
    private static int[] dx = {0, 0, -1, 1};

    private static int[][] maze;
    private static int[][] shortestPath;
    private static boolean[][] visited;
    private static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        maze = new int[n][m];
        shortestPath = new int[n][m];
        visited = new boolean[n][m];

        for (int y = 0; y < n; y++) {
            String map = br.readLine();
            for (int x = 0; x < m; x++) {
                maze[y][x] = map.charAt(x) - '0';
            }
        }

        dijkstra(0, 0);
        System.out.println(shortestPath[n-1][m-1]);
    }

    public static void dijkstra(int y, int x) {
        for (int i = 0; i < n; i++) Arrays.fill(shortestPath[i], 987654321);
        shortestPath[y][x] = 0;

        while (true) {
            int ny = 0;
            int nx = 0;

            int value = 987654321;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (visited[i][j]) continue;
                    if (value > shortestPath[i][j]) {
                        value = shortestPath[i][j];
                        ny = i;
                        nx = j;
                    }
                }
            }
            if (ny == n-1 && nx == m-1) break;
            visited[ny][nx] = true;

            for (int idx = 0; idx < 4; idx++) {
                int nny = ny + dy[idx];
                int nnx = nx + dx[idx];

                if (nny < 0 || nny >= n || nnx < 0 || nnx >= m) continue;
                if (visited[nny][nnx]) continue;

                if (maze[nny][nnx] == 1) shortestPath[nny][nnx] = Math.min(shortestPath[ny][nx] + 1, shortestPath[nny][nnx]);
                else shortestPath[nny][nnx] = Math.min(shortestPath[ny][nx], shortestPath[nny][nnx]);
            }
        }
    }
}
