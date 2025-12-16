package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_18290 {
    static int N, M, K;
    static int[][] map;
    static boolean[][] visit;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 0, 0, 0);

        System.out.println(max);
    }

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static void dfs(int y, int x, int depth, int sum) {
        if (K == depth) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = y; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i == y && j < x) {
                    continue;
                }
                if (visit[i][j]) {
                    continue;
                }
                if (check(i, j)) {
                    visit[i][j] = true;
                    dfs(i, j, depth + 1, sum + map[i][j]);
                    visit[i][j] = false;
                }
            }
        }
    }

    static boolean check(int r, int c) {
        for (int i = 0; i < 4; i++) {
            int ny = r + dy[i];
            int nx = c + dx[i];

            if (ny >= 0 && nx >= 0 && ny < N && nx < M) {
                if (visit[ny][nx]) {
                    return false;
                }
            }
        }
        return true;
    }
}
// S1 NM과 K (1) 백트래킹
// 53분
// 하다보니 시간이 많이 감 조건을 고려하는게 오래걸림 나는
// 벡터를 고려해서 조건문으로 반복문을 제어하고 재귀하려고 했는데
// check 를 통해서 방향을 탐색하는게 더 효율적이었다 이전의 값이 방문했는지에 대한 여부를 확인
// 그리고 i,j 를 그대로 넘기는게 문제였는데이또한 방문여부로 체크가능