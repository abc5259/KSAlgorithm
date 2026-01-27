package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1189 {
    static int R, C, K, cnt;
    static boolean[][] map;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new boolean[R][C];
        visit = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                if (str.charAt(j) == '.') {
                    map[i][j] = true;
                }
            }
        }

        visit[R - 1][0] = true;
        dfs(R - 1, 0, 1);

        System.out.println(cnt);
    }

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static void dfs(int y, int x, int depth) {
        if (depth == K) {
            if (y == 0 && x == C - 1) {
                cnt++;
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || nx < 0 || ny >= R || nx >= C || visit[ny][nx] || !map[ny][nx]) {
                continue;
            }
            visit[ny][nx] = true;
            dfs(ny, nx, depth + 1);
            visit[ny][nx] = false;
        }
    }
}
// S1 컴백홈 백트래킹
// 30분
// trouble shooting
// 좌표 매핑에 대한 실수 맨 왼쪽 위를 0,0 으로 잡고 목표는 0, C-1 로 했어야 했는데
// map 에 대한 매핑은 0,0 으로 해두고 실수로 출발지를 0,0 으로 생각해서 DFS 를 구현했다
// 그리고 깊이가 K 인 곳을 찾는거기때문에 DFS 로 접근하였고 목적지가 다를경우 뒤돌아가서
// 다시 시도하는 로직인 백트래킹을 통해서 구했다
// 방문 전후로 확인해서 기저 사례에 맞게 했다.