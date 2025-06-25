package BOJ.Hyeon.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1926 {
    static int n, m;
    static int[][] map;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visit = new boolean[n][m];

        int cnt = 0, max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 && !visit[i][j]) {
                    max = Math.max(max, bfs(i, j));
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
        System.out.println(max);
    }

    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};

    static int bfs(int y, int x) {
        Queue<int[]> queue = new ArrayDeque<>();
        visit[y][x] = true;
        queue.offer(new int[]{y, x});
        int size = 1;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            for (int i = 0; i < 4; i++) {
                int ny = poll[0] + dy[i];
                int nx = poll[1] + dx[i];

                if (nx < 0 || ny < 0 || nx >= m || ny >= n) {
                    continue;
                }

                if (visit[ny][nx]) {
                    continue;
                }

                if (map[ny][nx] == 1) {
                    size++;
                    visit[ny][nx] = true;
                    queue.offer(new int[]{ny, nx});
                }
            }
        }
        return size;
    }
}

// S1 그림 BFS
// retry 시간ㅇ벗