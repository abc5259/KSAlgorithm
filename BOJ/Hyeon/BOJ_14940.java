package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14940 {
    static int n, m;
    static int[][] map;
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], -1);
        }

        int y = 0, x = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    y = i;
                    x = j;
                } else if (map[i][j] == 0) {
                    dist[i][j] = 0;
                }
            }
        }

        bfs(y, x);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(dist[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static void bfs(int y, int x) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{y, x});
        dist[y][x] = 0;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            int cy = poll[0];
            int cx = poll[1];

            for (int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];

                if (ny < 0 || nx < 0 || ny >= n || nx >= m || map[ny][nx] == 0) {
                    continue;
                }

                if (dist[ny][nx] == -1) {
                    queue.offer(new int[]{ny, nx});
                    dist[ny][nx] = dist[cy][cx] + 1;
                }
            }
        }
    }
}
// S1 쉬운 최단거리 BFS
// 24분
// 일단 문제가 쉬웠다 굉장히 모든 가중치가 1로 작용하고 모든 컴포넌트들이 연결되어있길래
// 이는 방문 여부 및 거리를 계산하는 BFS 라고 생각
// 다만 입력값이 100만이어서 고려 최대가
// 근데 나는 재귀인줄알고 고려했는데 굳이 백트래킹을 할 필요가 없더라 왜냐하면 안가면 그만이니까
// 그래서 BFS 로 틀었다.
// trouble shooting
// 이게 문제가 조금 문해력이 헷갈렸는데 0은 갈 수 없는 땅 근데 갈 수 없는 땅은 0이 나와야되고
// 갈 수 있는데 도달을 못한건 -1 이 나와야 된다 그래서 dist 배열을 -1로 초기화를 할거다 왜냐하면
// bfs 로 못닿는 부분이 처음부터 -1이되게 근데 0으로 초기화를 언제할까 하다가 bfs 에서 갈 수 없는 땅이 나오면 그때 dist 를 0으로
// 초기화 시키려 했는데 bfs 로 못닿는데 갈 수 없는 땅이면 0이되어야 하는데 -1이 돼서 틀렸었다
// 그래서 처음부터 map 이 0이면 0을 넣었다.