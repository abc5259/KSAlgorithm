package BOJ.GiSeok.Java.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1520 {

    static int[] dy = { -1, 1, 0, 0 };
    static int[] dx = { 0, 0, -1, 1 };

    static int n, m;
    static int[][] map;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        dp = new int[n][m];
        for (int i = 0; i < n; i++) Arrays.fill(dp[i], -1);

        for (int y = 0; y < n; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < m; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        System.out.println(dp[0][0]);
    }

    /*
    0도 가능한 길일 수 있다는걸 간과함.
    왜냐면, 도착지가 ㅈㄴ 큰 오르막이면 갈 수 없어서 0이 정답인데
    0으로 dp 기준을 잡으면 모든 경우의 수를 시도해보고나서 0을 출력하기 때문에 시간초과가 나는 거였음
     */
    static int dfs(int y, int x) {
        if (y == (n-1) && x == (m-1)) {
            return 1;
        }

        dp[y][x] = 0;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
            if (map[y][x] <= map[ny][nx]) continue;
            if (dp[ny][nx] != -1) {
                dp[y][x] += dp[ny][nx];
                continue;
            }

            dp[y][x] += dfs(ny, nx);
        }

        return dp[y][x];
    }

    // 40% 시간초과
    /*
    static int dfs(int y, int x) {
        if (y == (n-1) && x == (m-1)) {
            return 1;
        }

        if (dp[y][x] != 0) return dp[y][x];

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
            if (map[y][x] <= map[ny][nx]) continue;

            dp[y][x] += dfs(ny, nx);
        }

        return dp[y][x];
    }
     */

    // 18% 시간초과
    /*
    static void dfs(int y, int x) {
        if (y == (n-1) && x == (m-1)) {
            ans++;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
            if (map[y][x] <= map[ny][nx]) continue;

            dfs(ny, nx);
        }
    }
     */
}
