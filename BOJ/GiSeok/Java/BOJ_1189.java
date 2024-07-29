/**
 * 1189 - 컴백홈 [성공|00:12:57]
 * 실버1, DFS, 시도1
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1189 {
    // 시간제한 2초, 메모리제한 128MB
    // 한수는 왼쪽 아래 점
    // 집은 오른쪽 위
    // 한수는 한번 지나친 곳 가지않음.
    // T로 표시된 부분은 가지 못하는 부분.
    // R * C 맵에 못가는 부분이 주어지고, 거리 K가 주어지면 집까지 도착하는 경우 중 거리가 K인 가짓수는?

    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static int[][] map;
    static boolean[][] visited;
    static int N, M, K;
    static int ret = 0;

    static void dfs(int y, int x, int cnt) {
        if (cnt > K) return;
        if (cnt == K && y == 0 && x == M - 1) {
            ret++;
            return;
        }

        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
            if (visited[ny][nx]) continue;
            if (map[ny][nx] == 'T') continue;

            visited[ny][nx] = true;
            dfs(ny, nx, cnt + 1);
            visited[ny][nx] = false;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int y = 0; y < N; y++) {
            String m = br.readLine();
            for (int x = 0; x < M; x++) {
                map[y][x] = m.charAt(x);
            }
        }

        visited = new boolean[N][M];
        dfs(N-1, 0, 1);

        System.out.println(ret);
    }
}
