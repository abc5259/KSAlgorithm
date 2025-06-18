package BOJ.Hyeon.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_3187 {
    static int R, C;
    static char[][] map;
    static boolean[][] visit;
    static int v, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visit = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (visit[i][j]) {
                    continue;
                }
                if (map[i][j] != '#') {
                    bfs(i, j);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(k).append(" ").append(v);
        System.out.println(sb);
    }

    static int dy[] = {1, 0, -1, 0};
    static int dx[] = {0, 1, 0, -1};

    static void bfs(int y, int x) {
        Queue<int[]> queue = new ArrayDeque<>();
        visit[y][x] = true;
        queue.offer(new int[]{y, x});

        int wolf = 0, sheep = 0;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int cy = poll[0];
            int cx = poll[1];
            if (map[cy][cx] == 'v') {
                wolf++;
            } else if (map[cy][cx] == 'k') {
                sheep++;
            }

            for (int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];

                if (ny < 0 || nx < 0 || ny >= R || nx >= C) {
                    continue;
                }
                if (visit[ny][nx]) {
                    continue;
                }
                if (map[ny][nx] != '#') {
                    visit[ny][nx] = true;
                    queue.offer(new int[]{ny, nx});
                }
            }
        }
        if (sheep > wolf) {
            k += sheep;
        } else {
            v += wolf;
        }
    }
}
// S1 양치기 꿍 BFS
