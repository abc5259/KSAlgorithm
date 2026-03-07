package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1937 {

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static int n;
    static int[][] map;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        for (int y = 0; y < n; y++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int x = 0; x < n; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        // 대나무 숲 위치 별로 최대한 많은 칸을 이동한 횟수를 저장?
        // 그걸 어케 저장함
        // 모든 위치를 시작점으로 모든 지점의 최대 이동 횟수를 구하기
        // -> n * n * n * n = 500^4 zz
        // 적어도 500^3 까지는 가능
        // 탐색하면서 계속 갱신하면 안되나?
        // 3 -> 6으로 갈때 6도 같이 갱신해버리기

        dp = new int[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(dp[i], -1);

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                dp[y][x] = dfs(y, x);
            }
        }

        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, dp[i][j]);
            }
        }

        System.out.println(ans);
    }

    private static int dfs(int y, int x) {
        if (dp[y][x] == -1) dp[y][x] = 1;
        else return dp[y][x]; // 이게 가능한 이유가 어차피 한 지점에 도착하면 네 방향 다 돌기때문에 무조건 최대 값을 구해서 dp에 저장하게 되어있음.
                              // 그래서 걍 한번만 거치면 얘는 최대값 구해진거임

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || ny >= n || nx < 0 || nx >= n) continue;
            if (map[ny][nx] <= map[y][x]) continue;

            dp[y][x] = Math.max(dfs(ny, nx) + 1, dp[y][x]);
        }

        return dp[y][x];
    }
}
