package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1743_1 {
    static int N, M, cnt;
    static boolean[][] map;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        map = new boolean[N + 1][M + 1];
        visit = new boolean[N + 1][M + 1];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[r][c] = true;
        }

        int max = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (map[i][j] && !visit[i][j]) {
                    cnt = 0;
                    dfs(i, j);
                    max = Math.max(max, cnt);
                }
            }
        }
        System.out.println(max);
    }

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static void dfs(int y, int x) {
        visit[y][x] = true;
        cnt++;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || nx < 0 || ny > N || nx > M || visit[ny][nx]) {
                continue;
            }
            if (map[ny][nx]) {
                dfs(ny, nx);
            }
        }
    }
}
// S1 음식물 피하기 DFS
// 10분
// 그냥 문제자체가 BFS 이든 DFS 이든 풀 수있다 왜냐하면
// 섬의 개수를 구하는 것과 같이 모든 칸을 다 방문하며 비교를 하는 문제는 가능하다
// BFS로 순서대로 큐에 넣어서 칠하든 DFS로 끝까지 갔다가 칠하든 같은 문제다
// 예를들어 청소를 한다고 쳤을 때 map 의 크기에 있어서
// BFS 는 내 발밑부터 둥글게 청소를 해 나가는 것이고
// DFS 는 끝까지 걸레를 밀고 벽 까지 갔다가, 다시 돌아와서 닦는다
// 그래서 어떤 방식으로 닦는 결국 방 전체를 다 닦은 결과와 면적은 같기에 연결된 덩어리의 개수를 구하는 문제는 둘다 가능하다
// 최단거리다? BFS
// 방문 순서가 중요하다 ? DFS
// 둘다 아니면 가능 연결요소