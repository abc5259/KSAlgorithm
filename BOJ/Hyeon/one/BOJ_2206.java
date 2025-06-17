package BOJ.Hyeon.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2206 {
    static int[][] map;
    static boolean[][][] visit;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visit = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        int res = bfs();
        System.out.println(res);
    }

    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {1, -1, 0, 0};

    static int bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0, 1, 0});
        // 거리,  안부숨 벽부숨
        visit[0][0][0] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            int y = poll[0];
            int x = poll[1];
            int dis = poll[2];
            int broken = poll[3];

            if (y == N - 1 && x == M - 1) {
                return dis;
            }
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 0 || nx < 0 || ny >= N || nx >= M) {
                    continue;
                }

                if (map[ny][nx] == 0 && !visit[ny][nx][broken]) {
                    visit[ny][nx][broken] = true;
                    queue.offer(new int[]{ny, nx, dis + 1, broken});
                }

                if (map[ny][nx] == 1 && broken == 0 && !visit[ny][nx][1]) {
                    visit[ny][nx][1] = true;
                    queue.offer(new int[]{ny, nx, dis + 1, 1});
                }
            }
        }
        return -1;
    }
}

// G3 벽 부수고 이동하기 BFS
// retry