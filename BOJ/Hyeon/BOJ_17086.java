package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_17086 {
    static int N, M, res;
    static int[][] ocean;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ocean = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                ocean[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        res = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (ocean[i][j] == 0) {
                    int tmp = bfs(i, j);
                    res = Math.max(tmp, res);
                }
            }
        }
        System.out.print(res);
    }

    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};


    static int bfs(int y, int x) {
        boolean[][] visit = new boolean[N][M];

        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{y, x, 0});
        visit[y][x] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            for (int i = 0; i < 8; i++) {
                int ny = poll[0] + dy[i];
                int nx = poll[1] + dx[i];

                if (ny < 0 || nx < 0 || ny >= N || nx >= M || visit[ny][nx]) {
                    continue;
                }
                if (ocean[ny][nx] == 1) {
                    return poll[2] + 1;
                }
                queue.offer(new int[]{ny, nx, poll[2] + 1});
                visit[ny][nx] = true;
            }
        }
        return 0;
    }
}
// S2 아기 상어 2 BFS
// 일단 풀었다 쉽게 접근