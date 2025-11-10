package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16929 {
    static boolean possible;
    static int N, M;
    static char[][] grid;
    static int[][] depth;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grid = new char[N][M];
        depth = new int[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                grid[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (depth[i][j] == 0) {
                    dfs(i, j, 1);
                }
                if (possible) {
                    System.out.println("Yes");
                    return;
                }
            }
        }
        System.out.println("No");
    }

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static void dfs(int y, int x, int d) {
        depth[y][x] = d;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || nx < 0 || ny >= N || nx >= M) {
                continue;
            }
            if (grid[ny][nx] == grid[y][x]) {
                if (depth[ny][nx] == 0) {
                    dfs(ny, nx, d + 1);
                } else {
                    if (d - depth[ny][nx] >= 3) {
                        possible = true;
                        return;
                    }
                }
            }
            if (possible) {
                return;
            }
        }
    }
}
// G4 Two Dots DFS
// 58분
// trouble shooting
// 출력 문자열 주의
// dfs 학습할 때 고려할 점 - 방문 여부 고려해서
// 그리고 possible 변수로 따로 탈출 조건 생성