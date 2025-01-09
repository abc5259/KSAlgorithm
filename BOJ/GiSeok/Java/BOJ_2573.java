/**
 * [G4 그래프] 빙산 - O, 00:29:28
 * 시도3
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2573 {

    private static int[] dy = {-1, 1, 0, 0};
    private static int[] dx = {0, 0, -1, 1};

    private static int[][] map;
    private static boolean[][] visited;
    private static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        boolean flag = true;
        while (!isAllZero()) {
            int cnt = 0;
            visited = new boolean[n][m];
            for (int y = 0; y < n; y++) {
                for (int x = 0; x < m; x++) {
                    if (!visited[y][x] && map[y][x] != 0) {
                        dfs(y, x);
                        cnt++;
                    }
                }
            }

            if (cnt >= 2) { flag = false; break; }

            int[][] copymap = new int[n][m];
            for (int i = 0; i < n; i++) copymap[i] = map[i].clone();

            for (int y = 0; y < n; y++) {
                for (int x = 0; x < m; x++) {
                    if (map[y][x] != 0) {
                        int ice = 0;
                        for (int c = 0; c < 4; c++) {
                            int ny = y + dy[c];
                            int nx = x + dx[c];

                            if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                            if (map[ny][nx] == 0) ice++;
                        }

                        copymap[y][x] = Math.max(copymap[y][x] - ice, 0);
                    }
                }
            }
            for (int i = 0; i < n; i++) map[i] = copymap[i].clone();
            ans++;
        }

        if (flag) System.out.println(0);
        else System.out.println(ans);
    }

    public static void dfs(int y, int x) {
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
            if (visited[ny][nx]) continue;
            if (map[ny][nx] == 0) continue;

            dfs(ny, nx);
        }
    }

    public static boolean isAllZero() {
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                if (map[y][x] != 0) return false;
            }
        }
        return true;
    }
}
