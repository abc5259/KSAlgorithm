/**
 * 1103 - 게임 [실패|01:43:04]
 * 골드2, DFS/DP, 시도6
 */
package BOJ.GiSeok.Java;
import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1103 {
    // 시간제한 2초, 메모리제한 512MB
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int n, m, ret;
    static int[][] board, dp;
    static boolean[][] visited;

    static void go(int y, int x, int cnt) {

        if (ret == Integer.MAX_VALUE) return;

        ret = Math.max(ret, cnt);
        for (int i = 0; i < 4; i++) {
            int ny = y + board[y][x] * dy[i];
            int nx = x + board[y][x] * dx[i];

            if (ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
            if (board[ny][nx] == -1) continue;
            if (visited[ny][nx]) { ret = Integer.MAX_VALUE; return; }
            if (cnt + 1 > dp[ny][nx]) {
                dp[ny][nx] = cnt + 1;
                visited[ny][nx] = true;
                go(ny, nx, cnt+1);
                visited[ny][nx] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        visited = new boolean[n][m];
        dp = new int[n][m];
        for (int y = 0; y < n; y++) {
            String s = br.readLine();
            for (int x = 0; x < m; x++) {
                if (s.charAt(x) == 'H') board[y][x] = -1;
                else board[y][x] = s.charAt(x) - '0';
            }
        }

        visited[0][0] = true;
        go(0, 0, 1);

        if (ret == Integer.MAX_VALUE) ret = -1;
        System.out.println(ret);
    }
}
