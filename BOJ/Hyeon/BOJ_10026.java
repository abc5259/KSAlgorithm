package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class BOJ_10026 {
    static int N;
    static char[][] grid;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        grid = new char[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                grid[i][j] = str.charAt(j);
            }
        }

        int normal = 0;

        visit = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j]) {
                    bfs(i, j);
                    normal++;
                }
            }
        }

        int special = 0;

        visit = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j]) {
                    specialBfs(i, j);
                    special++;
                }
            }
        }
        System.out.println(normal + " " + special);
    }

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static void bfs(int y, int x) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{y, x});
        visit[y][x] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            int cy = poll[0];
            int cx = poll[1];

            for (int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];

                if (ny < 0 || nx < 0 || ny >= N || nx >= N || visit[ny][nx]) {
                    continue;
                }
                if (grid[cy][cx] != grid[ny][nx]) {
                    continue;
                }
                queue.offer(new int[]{ny, nx});
                visit[ny][nx] = true;
            }
        }
    }

    static void specialBfs(int y, int x) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{y, x});
        visit[y][x] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            int cy = poll[0];
            int cx = poll[1];

            for (int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];

                if (ny < 0 || nx < 0 || ny >= N || nx >= N || visit[ny][nx]) {
                    continue;
                }
                if (grid[cy][cx] == 'B' && grid[ny][nx] != 'B') {
                    continue;
                } else if (grid[cy][cx] != 'B' && grid[ny][nx] == 'B') {
                    continue;
                }
                queue.offer(new int[]{ny, nx});
                visit[ny][nx] = true;
            }
        }
    }
}
// G5 적록색약 BFS
// 13분
// 일단 1초 라는 시간과 내가 너비를 우선 탐색해서 끝까지 나랑 같은 색이 나와서 거기를 방문한다 치면
// 일단 최초 방문만 허용이라는 점이 BFS 와 같았고 이러한 BFS를 통해 영역의 개수를 구하는게 문제였다.
// 그냥 2개의 BFS 를 만들어서 돌리면 그만이었다. 근데 여기서 고민이 되는 점은
// 좀 더 개선할 수 없었을까? 혹은 grid 를 그냥 B냐 아니냐로 바꿔버렸어야 했나 싶기도 하고
// 거의 중복되는 코드가 너무 많아서 고민이다