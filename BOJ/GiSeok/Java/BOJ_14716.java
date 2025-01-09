/**
 * [S1 DFS] 현수막 - O, 00:02:20
 * 시도1
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14716 {

    private static int[] dy = {-1, 1, 0, 0, -1, -1, 1, 1};
    private static int[] dx = {0, 0, -1, 1, -1, 1, -1, 1};

    private static int[][] banner;
    private static boolean[][] visited;
    private static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        banner = new int[n][m];
        visited = new boolean[n][m];
        for (int y = 0; y < n; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < m; x++) banner[y][x] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                if (banner[y][x] != 0 && !visited[y][x]) {
                    dfs(y, x);
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }

    public static void dfs(int y, int x) {
        visited[y][x] = true;

        for (int i = 0; i < 8; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
            if (visited[ny][nx]) continue;
            if (banner[ny][nx] == 0) continue;

            dfs(ny, nx);
        }
    }
}
