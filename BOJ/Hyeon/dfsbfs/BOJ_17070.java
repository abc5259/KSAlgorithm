package BOJ.Hyeon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17070 {
    static int[] dy = {0, 1, 1};
    static int[] dx = {1, 0, 1};

    static int[][] home;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        home = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                home[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 1, 0);
        System.out.println(cnt);
    }

    static int cnt;

    static void dfs(int y, int x, int dir) {

        if (y == N - 1 && x == N - 1) {
            cnt++;
            return;
        }
        for (int i = 0; i < 3; i++) {
            if ((dir == 0 && i == 1) || (dir == 1 && i == 0)) {
                continue;
            }
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny >= N || nx >= N || home[ny][nx] != 0) {
                continue;
            }
            if (i == 2 && (home[ny - 1][nx] != 0 || home[ny][nx - 1] != 0)) {
                continue;
            }
            dfs(ny, nx, i);
        }
    }
}
