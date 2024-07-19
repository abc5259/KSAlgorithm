/**
 * 2636 - 치즈 [성공|00:27:07]
 * 골드4, 그래프이론, 시도1
 * 
 * 시간 복잡도는 map 전체가 0인지 검사하는 isZeroMap = 100^2
 * map에 치즈 갯수를 세는 cheezeCnt = 100^2
 * dfs = 100^2
 * (10000 + 10000 + 10000) * 50 = 150만 1초안에 해결 가능
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2636 {
    // 시간제한 1초, 메모리제한 128MB
    // 공기 중에 닿은 치즈가 점점 줄어듦
    // 상하좌우 중에 공기가 있는 치즈는 1시간 후에 녹는다.
    // 0으로 dfs, bfs를 돌리면서 1을 하나씩 지워나가면 될듯.

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

            if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
            if (map[ny][nx] == 1) {
                visited[ny][nx] = true;
                map[ny][nx] = 0;
                continue;
            }
            if (visited[ny][nx]) continue;

            dfs(ny, nx);
        }
    }

    static boolean isZeroMap() {
        int n = map[0][0];
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                if (map[y][x] != n) return false;
            }
        }

        return true;
    }

    static int cheezeCnt() {
        int cnt = 0;
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                if (map[y][x] == 1) cnt++;
            }
        }

        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        int ret = 0;
        int time = 0;
        while (!isZeroMap()) {
            ret = cheezeCnt();
            time++;

            visited = new boolean[N][M];
            dfs(0, 0);
        }

        System.out.println(time);
        System.out.println(ret);
    }
}
