package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2638 {
    static int N, M;
    static int[][] map;
    static boolean[][] visit;
    static int remainCheese = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    remainCheese++;
                }
            }
        }
        int time = 0;

        while (remainCheese > 0) {
            time++;

            outer();

            List<int[]> cheese = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 1) {
                        int cnt = 0;

                        for (int d = 0; d < 4; d++) {
                            int ny = i + dy[d];
                            int nx = j + dx[d];

                            if (ny < 0 || nx < 0 || ny >= N || nx >= M) {
                                continue;
                            }
                            if (visit[ny][nx]) {
                                cnt++;
                            }
                        }
                        if (cnt >= 2) {
                            cheese.add(new int[]{i, j});
                        }
                    }
                }
            }
            for (int[] pos : cheese) {
                map[pos[0]][pos[1]] = 0;
                remainCheese--;
            }
        }
        System.out.println(time);
    }

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static void outer() {
        visit = new boolean[N][M];
        ArrayDeque<int[]> queue = new ArrayDeque<>();

        queue.offer(new int[]{0, 0});
        visit[0][0] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            for (int i = 0; i < 4; i++) {
                int ny = poll[0] + dy[i];
                int nx = poll[1] + dx[i];

                if (ny < 0 || nx < 0 || ny >= N || nx >= M || visit[ny][nx]) {
                    continue;
                }
                if (map[ny][nx] == 0) {
                    queue.offer(new int[]{ny, nx});
                    visit[ny][nx] = true;
                }
            }
        }
    }
}
// G3 치즈 BFS
// 46분
// 일단 외부로 공기를 세는 BFS 와 치즈가 녹는 과정을 돌리는 BFS 2개를 써야한다.