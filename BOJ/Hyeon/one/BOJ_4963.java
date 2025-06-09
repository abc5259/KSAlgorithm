package BOJ.Hyeon.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_4963 {
    static int[][] map;
    static boolean[][] visit;
    static int h, w;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            if (w == 0) {
                break;
            }
            h = Integer.parseInt(st.nextToken());

            map = new int[h][w];
            visit = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int cnt = 0;

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == 1 && !visit[i][j]) {
                        bfs(i, j);
                        cnt++;
                    }
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.print(sb);
    }

    static int[] dy = {1, -1, 0, 0, 1, -1, 1, -1};
    static int[] dx = {0, 0, -1, 1, 1, -1, -1, 1};

    static void bfs(int row, int col) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{row, col});

        visit[row][col] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            for (int i = 0; i < 8; i++) {
                int ny = poll[0] + dy[i];
                int nx = poll[1] + dx[i];

                if (ny >= 0 && nx >= 0 && ny < h && nx < w && !visit[ny][nx] && map[ny][nx] == 1) {
                    visit[ny][nx] = true;
                    queue.offer(new int[]{ny, nx});
                }
            }
        }
    }
}

// S2 섬의 개수 BFS
// 일단 BFS 로 풀었다. 큐에 넣어서 빼고 넣고 다시 생각 필요