package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_14497 {
    static int N, M;
    static char[][] map;
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int y1 = Integer.parseInt(st.nextToken()) - 1;
        int x1 = Integer.parseInt(st.nextToken()) - 1;
        int y2 = Integer.parseInt(st.nextToken()) - 1;
        int x2 = Integer.parseInt(st.nextToken()) - 1;

        map = new char[N][M];
        dist = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
                dist[i][j] = -1;
            }
        }

        System.out.println(bfs(y1, x1, y2, x2));
    }

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static int bfs(int startY, int startX, int endY, int endX) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{startY, startX});
        dist[startY][startX] = 0;

        while (!queue.isEmpty()) {
            int[] poll = queue.pollFirst();

            int cy = poll[0];
            int cx = poll[1];

            if (cy == endY && cx == endX) {
                return dist[cy][cx];
            }
            for (int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];

                if (ny < 0 || nx < 0 || ny >= N || nx >= M || dist[ny][nx] != -1) {
                    continue;
                }
                if (map[ny][nx] == '1' || map[ny][nx] == '#') {
                    queue.addLast(new int[]{ny, nx});
                    dist[ny][nx] = dist[cy][cx] + 1;
                } else {
                    queue.addFirst(new int[]{ny, nx});
                    dist[ny][nx] = dist[cy][cx];
                }
            }

        }
        return 0;
    }
}
// G4 주난의 난(難) 0-1 BFS
// 30분
// 친구가 벽 역할 다시
