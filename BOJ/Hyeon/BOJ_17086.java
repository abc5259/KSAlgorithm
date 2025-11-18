package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17086 {
    static int N, M;
    static int[][] map;
    static int[][] dis;
    static ArrayDeque<int[]> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dis = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
            Arrays.fill(dis[i], -1);
        }

        queue = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                    dis[i][j] = 0;
                }
            }
        }

        bfs();

        int max = Integer.MIN_VALUE;
        for (int[] r : dis) {
            for (int res : r) {
                max = Math.max(max, res);
            }
        }
        System.out.println(max);
    }

    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};

    static void bfs() {

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int s = 0; s < size; s++) {
                int[] poll = queue.poll();
                int cy = poll[0];
                int cx = poll[1];

                for (int i = 0; i < 8; i++) {
                    int ny = cy + dy[i];
                    int nx = cx + dx[i];

                    if (ny < 0 || nx < 0 || ny >= N || nx >= M || dis[ny][nx] != -1) {
                        continue;
                    }
                    queue.offer(new int[]{ny, nx});
                    dis[ny][nx] = dis[cy][cx] + 1;
                }
            }
        }
    }
}
// S2 아기 상어 2 BFS
// 17분
// 일단 N X M 모형의 칸에서 각 빈칸과 아기상어가 존재한다
// 아기상어로부터 각 빈칸은 얼마나 안전한지 아기상어와의 거리를 물어보는 문제였다
// 이러면 내가 처음으로 아기상어를 만난게 최초일거고 최단거리일테니 그런거를 물어보는건 BFS라고 생각했다
// 그런데 8방향으로 간다해서 8방향 벡터를 쓰고 4방향과똑같이 하는데 문제점이
// 안전거리가 움직일 필요없이 상어가 얼마나 올 수 있냐 해당 빈칸까지 거리를 구하면
// 만약 아기상어가 현재 빈칸까지 오는 최단거리가 3이라면 그 빈칸이 가진 안전거리도 3이라고 생각했다
// 그래서 아기상어의 모든 좌표를 큐에 넣고 각 큐마다 아기상어의 거리 별 즉 size 로 해서 플러드필 했다
// 여태 계속 bfs 진입했을 때 큐에 넣고 했지만
// 이번에는 만약 아기상어가 5마리가 있다면 5마리가 1칸씩 움직이지 1마리가 모든 너비를 다 탐색하고 2번째 상어가 출발하는게 아니라고 생각해서
// 모든 상어를 큐에 다 넣고 큐의 사이즈 별로 진행했다.