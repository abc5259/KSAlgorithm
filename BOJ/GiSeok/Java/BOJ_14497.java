/**
 * 14497 - 주난의 난 [성공|00:48:45]
 * 골드4, DFS, 시도2
 * 
 * 저번에 풀었던 치즈 문제처럼 풀면 되는 문제였다.
 * 가장 가까이 있는 1을 먼저 지우고, cnt++
 * 다시 dfs 돌려서 가까이 있는 1을 지우고 cnt++
 * 이를 범인 잡을때까지 반복한다.
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14497 {
    // 시간제한 2초
    // N*M 크기의 학교 교실
    // 주난이가 뛸 때마다 파동이 상하좌우 4방향으로 친구들을 쓰러뜨림.
    // 파동은 장애물(친구)를 만날때까지 퍼진다.
    // 치즈 문제처럼 풀면 될듯

    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static int[][] map;
    static boolean[][] visited;
    static int N, M;

    static void dfs(int y, int x) {
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
            if (visited[ny][nx]) continue;
            if (map[ny][nx] == 1) {
                map[ny][nx] = 0;
                visited[ny][nx] = true;
                continue;
            } else if (map[ny][nx] == 3) {
                map[ny][nx] = -1;
                visited[ny][nx] = true;
                return;
            }

            dfs(ny, nx);
        }
    }

    static boolean check() {
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                if (map[y][x] == 3) return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        st = new StringTokenizer(br.readLine());
        int y1 = Integer.parseInt(st.nextToken()) - 1;
        int x1 = Integer.parseInt(st.nextToken()) - 1;
        Integer.parseInt(st.nextToken()); Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String m = br.readLine();
            for (int j = 0; j < M; j++) {
                if (m.charAt(j) == '*') map[i][j] = 2; // 주난
                else if (m.charAt(j) == '#') map[i][j] = 3; // 범인
                else map[i][j] = (m.charAt(j) - '0');
            }
        }

        int ret = 0;
        while (!check()) {
            visited = new boolean[N][M];
            dfs(y1, x1);
            ret++;
        }

        System.out.println(ret);
    }
}
