package BOJ.Hyeon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1520 {
    static int N, M;
    static int[][] map;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dp = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
            Arrays.fill(dp[i], -1);
        }

        System.out.println(dfs(0, 0));
    }

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    static int dfs(int y, int x) {
        if (y == N - 1 && x == M - 1) {
            return 1;
        }
        if (dp[y][x] != -1) {
            return dp[y][x];
        }

        dp[y][x] = 0;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || nx < 0 || ny >= N || nx >= M) {
                continue;
            }
            if (map[ny][nx] < map[y][x]) {
                dp[y][x] += dfs(ny, nx);
            }
        }
        return dp[y][x];
    }
}
// G3 내리막 길 DP + DFS
// 1시간 후 실패
// DP + DFS 인거 알고있었는데 구현을 못했다. 기저사례 예상 못함 0
// 니가 이미 3번 간 횟수의 갈림길내가 2번 으로 해서 왔음 그럼 총 5번이어야됨
// 근데 내가 처음간길 1인데 만났다 그럼 2가 됐음 뒤에까지 다 가야되나?
// visit 필요없음 무조건 내려가니까