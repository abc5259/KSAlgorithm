/**
 * [S1 DFS] 그림 - O, 00:23:54
 * 시도2
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1926 {

    private static int[] dy = {-1, 1, 0, 0};
    private static int[] dx = {0, 0, -1, 1};

    private static int[][] paper;
    private static boolean[][] visited;
    private static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        paper = new int[n][m];
        visited = new boolean[n][m];
        for (int y = 0; y < n; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < m; x++) paper[y][x] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        int max = 0;
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                if (paper[y][x] != 0 && !visited[y][x]) {
                    max = Math.max(dfs(y, x), max);
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
        System.out.println(max);
    }

    public static int dfs(int y, int x) {
        visited[y][x] = true;

        int tmp = 1;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
            if (visited[ny][nx]) continue;
            if (paper[ny][nx] == 0) continue;

            tmp += dfs(ny, nx);
        }

        return tmp;
    }
}
