package BOJ.GiSeok.Java.retry;

// 00:05:43 S1
import java.util.*;
import java.io.*;

public class BOJ_1926 {

    static final int[] dy = {-1, 1, 0, 0};
    static final int[] dx = {0, 0, -1, 1};

    static int n, m;
    static int[][] paints;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        paints = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                paints[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        int ret = 0;
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j]) {
                    continue;
                }
                if (paints[i][j] == 0) {
                    continue;
                }
                visited[i][j] = true;
                ret = Math.max(ret, dfs(i, j));
                cnt++;
            }
        }

        System.out.println(cnt);
        System.out.println(ret);
    }

    static int dfs(int y, int x) {
        int cnt = 1;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || ny >= n || nx < 0 || nx >= m) {
                continue;
            }
            if (visited[ny][nx]) {
                continue;
            }
            if (paints[ny][nx] == 0) {
                continue;
            }

            visited[ny][nx] = true;
            cnt += dfs(ny, nx);
        }

        return cnt;
    }
}
