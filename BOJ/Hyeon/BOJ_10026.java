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
        visit = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                grid[i][j] = str.charAt(j);
            }
        }

        int normal = 0;

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
                if (grid[cy][cx] == 'R' && grid[ny][nx] == 'B') {
                    continue;
                }
                if (grid[cy][cx] == 'G' && grid[ny][nx] == 'B') {
                    continue;
                }
                if (grid[cy][cx] == 'B' && grid[ny][nx] != 'B') {
                    continue;
                }
                queue.offer(new int[]{ny, nx});
                visit[ny][nx] = true;
            }
        }
    }
}
// G5 적록색약 BFS
// 18분
// 2개의 탈출 조건
// 노말은 그냥 현재 값과 새로운 4방향 벡터의 값의 차이
// 색약은 현재 색이 녹이나 적일 떄 움직였을 떄 파랑이거나
// 현재가 파랑일 때 움직였을 때 파랑이 아닐 경우를 탈출 조건으로 가지는 너비 우선 탐색으로 하고
// offer 하고 visit 해서 2개의 visit 로 관리했다.