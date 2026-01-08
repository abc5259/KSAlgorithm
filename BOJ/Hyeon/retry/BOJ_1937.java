package BOJ.Hyeon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1937 {
    static int n;
    static int[][] map;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        dp = new int[n][n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dfs(i, j));
            }
        }

        System.out.println(max);
    }

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static int dfs(int y, int x) {
        if (dp[y][x] != 0) {
            return dp[y][x];
        }

        dp[y][x] = 1;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || nx < 0 || ny >= n || nx >= n) {
                continue;
            }

            if (map[y][x] < map[ny][nx]) {
                dp[y][x] = Math.max(dp[y][x], dfs(ny, nx) + 1);
            }
        }
        return dp[y][x];
    }
}
// G3 욕심쟁이 판다 DFS + DP
// 2시간
// 진짜 예상하지 못한 문제.
// BFS 로 접근하려고 했다 그러니까 N이 500인데 500 ^2 브루트 포스에 BFS 를 돌리니까
// 500 ^ 2 * 500 ^ 2였다. 이는 간선 수가 얼만지는 모르겠는데,, 4개방향이고
// 또 DFS 로 백트래킹을 쓰자니 4^500^2라고 하고,,
// 그래서 메모이제이션을 통해 내가 한번 센적있는 곳은 다시 연산을 안하게 하고
// 또 DFS 를 통해서 파고 들어가는게 나을 거 같다고 판단
// 파고 들어가면서 메모이제이션 발견하면 값 비교해서 dp 에 최적화된 값 저장
// 그리고 기저사례 이미 방문 한적있으면 그값만 리턴
// 그래서 이거에 대한 최대값 즉 최대 칸수 최대경로 리턴