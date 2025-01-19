/**
 * [G4 BFS] 녹색 옷 입은 애가 젤다지? - O, 00:10:27
 * 시도 2
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_4485_2 {

    private static int[] dy = {-1, 1, 0, 0};
    private static int[] dx = {0, 0, -1, 1};

    private static int[][] dungeon;
    private static int[][] visited;
    private static int n;

    private static class Point {
        int y, x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = 1;
        while ((n = Integer.parseInt(br.readLine())) != 0) {
            dungeon = new int[n][n];
            visited = new int[n][n];
            for (int i = 0; i < n; i++) Arrays.fill(visited[i], 987654321);

            for (int y = 0; y < n; y++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int x = 0; x < n; x++) dungeon[y][x] = Integer.parseInt(st.nextToken());
            }

            bfs(0, 0);
            System.out.printf("Problem %d: %d\n", t++, visited[n-1][n-1]);
        }
    }

    private static void bfs(int y, int x) {
        ArrayDeque<Point> q = new ArrayDeque<>();
        q.add(new Point(y, x));

        visited[y][x] = dungeon[y][x];
        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int i = 0; i < 4; i++) {
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];

                if (ny < 0 || ny >= n || nx < 0 || nx >= n) continue;
                if (visited[ny][nx] <= visited[p.y][p.x] + dungeon[ny][nx]) continue;

                visited[ny][nx] = visited[p.y][p.x] + dungeon[ny][nx];
                q.add(new Point(ny, nx));
            }
        }
    }
}
