package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_3187 {
    static int R, C, wolf, sheep;
    static char[][] map;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visit = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (!visit[i][j] && map[i][j] != '#') {
                    bfs(i, j);
                }
            }
        }
        System.out.print(sheep + " " + wolf);
    }

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static void bfs(int y, int x) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{y, x});

        visit[y][x] = true;

        int v = 0, k = 0;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            int cy = poll[0];
            int cx = poll[1];

            if (map[cy][cx] == 'v') {
                v++;
            } else if (map[cy][cx] == 'k') {
                k++;
            }

            for (int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];

                if (ny < 0 || nx < 0 || ny >= R || nx >= C || visit[ny][nx] || map[ny][nx] == '#') {
                    continue;
                }
                queue.offer(new int[]{ny, nx});
                visit[ny][nx] = true;
            }
        }

        if (k > v) {
            sheep += k;
        } else {
            wolf += v;
        }
    }
}
// S1 양치기 꿍 BFS
// 10분
// 일단 풀어봤던거라서 쉽게 풀었다.
// poll 하고 나서 v 인지 k 인지 점검을 하고 4 방향 탐색 시에는 그냥 가볍게
// 범위 제한만 해서 continue 아니면 offer 하고 그렇게 방문 여부 확인한다.
// bfs 탈출 시에 조건문으로 정적변수에 합한다.