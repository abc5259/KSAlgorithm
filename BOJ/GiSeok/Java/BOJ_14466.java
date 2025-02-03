/**
 * [G3 BFS] 소가 길을 건너간 이유 6 - O(왜 맞음..?), 02:12:25
 * 시도 12
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_14466 {

    private static int[] dy = {-1, 1, 0, 0};
    private static int[] dx = {0, 0, -1, 1};

    private static int n, k, r;

    static class Point {
        int y, x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        ArrayList<Point>[][] map = new ArrayList[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) map[i][j] = new ArrayList<>();
        }
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int sy = Integer.parseInt(st.nextToken());
            int sx = Integer.parseInt(st.nextToken());
            int ey = Integer.parseInt(st.nextToken());
            int ex = Integer.parseInt(st.nextToken());

            map[sy][sx].add(new Point(ey, ex));
            map[ey][ex].add(new Point(sy, sx));
        }

        ArrayList<Point> cows = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            cows.add(new Point(y, x));
        }

        int ret = 0;
        for (int i = 0; i < k; i++) {
            ArrayDeque<Point> q = new ArrayDeque<>();
            q.add(new Point(cows.get(i).y, cows.get(i).x));

            boolean[][] visited = new boolean[n+1][n+1];
            visited[cows.get(i).y][cows.get(i).x] = true;
            while (!q.isEmpty()) {
                Point p = q.poll();

                for (int idx = 0; idx < 4; idx++) {
                    int ny = p.y + dy[idx];
                    int nx = p.x + dx[idx];

                    if (ny <= 0 || ny > n || nx <= 0 || nx > n) continue;
                    if (visited[ny][nx]) continue;

                    boolean flag = false;
                    for (int j = 0; j < map[p.y][p.x].size(); j++) {
                        if (map[p.y][p.x].get(j).y == ny && map[p.y][p.x].get(j).x == nx) {
                            flag = true;
                            break;
                        }
                    }
                    if (flag) continue;

                    visited[ny][nx] = true;
                    q.add(new Point(ny, nx));
                }
            }

            for (int j = i+1; j < k; j++) {
                if (!visited[cows.get(j).y][cows.get(j).x]) ret++;
            }
        }

        System.out.println(ret);
    }
}
