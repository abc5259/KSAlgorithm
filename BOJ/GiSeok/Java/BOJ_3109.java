/**
 * [G2 DFS] 빵집 - 🔺(반례힌트), 01:24:26
 * 시도 6
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3109 {

    static int[] dy = {-1, 0, 1};
    static int[] dx = {1, 1, 1};

    private static char[][] map;
    private static boolean[][] visited;
    private static int r, c;
    private static int ret = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        visited = new boolean[r][c];
        for (int y = 0; y < r; y++) {
            String line = br.readLine();
            for (int x = 0; x < c; x++) {
                map[y][x] = line.charAt(x);
            }
        }

        for (int y = 0; y < r; y++) {
            if (dfs(y, 0)) ret++;
        }
        System.out.println(ret);
    }

    public static boolean dfs(int y, int x) {
        visited[y][x] = true;
        if (x == c-1) {
            return true;
        }

        for (int i = 0; i < 3; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || ny >= r || nx < 0 || nx >= c) continue;
            if (map[ny][nx] == 'x') continue;
            if (visited[ny][nx]) continue;

            if (dfs(ny, nx)) {
                return true;
            }
        }

        map[y][x] = 'x';
        return false;
    }
}
