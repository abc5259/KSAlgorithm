package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_1743 {
    static int N, M;
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
                    int tmp = bfs(i, j);
                    max = Math.max(max, tmp);
                }
            }
        }
        System.out.println(max);
    }

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static int bfs(int y, int x) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{y, x});
        visit[y][x] = true;

        int size = 1;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            int cy = poll[0];
            int cx = poll[1];

            for (int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];

                if (ny < 0 || nx < 0 || ny > N || nx > M || visit[ny][nx]) {
                    continue;
                }
                if (map[ny][nx]) {
                    queue.offer(new int[]{ny, nx});
                    size++;
                    visit[ny][nx] = true;
                }
            }
        }
        return size;
    }
}
// S1 음식물 피하기 BFS
// 8분
// 일단 읽고 보는데 이어진 섬의 가장 큰 땅을 구하는 문제 길래 BFS 인줄 알았다
// 그런데 플러드필로 하는게 아닌 갈 수 있는 최대의 거리를 구하는 거길래
// dfs 로도 될 거 같아서 dfs 를 고민했는데 그냥 해당 갈 수 잇는 좌표의 개수를 할까 하다가
// queue 에 넣을때마다 갯수를 증가시켜서 이를 리턴하게 해서 비교했다
// 쓰레기냐 아니냐 boolean map 과 방문했냐 안했냐는 visit 를 2개를 썼다.