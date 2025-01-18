/**
 * [G3 BFS] 레이저 통신 - X
 * 시도 12
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_6087_2 {

    private static class Point implements Comparable<Point> {
        int y, x, dir, mirror;

        public Point(int y, int x, int dir, int mirror) {
            this.y = y;
            this.x = x;
            this.dir = dir;
            this.mirror = mirror;
        }

        @Override
        public int compareTo(Point o) {
            return this.mirror - o.mirror;
        }
    }

    private static int[] dy = {-1, 1, 0, 0};
    private static int[] dx = {0, 0, -1, 1};

    private static char[][] map;
    private static int[][][] visited;
    private static int h, w;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        int startY = 0;
        int startX = 0;
        map = new char[h][w];
        for (int y = 0; y < h; y++) {
            String m = br.readLine();
            for (int x = 0; x < w; x++) {
                map[y][x] = m.charAt(x);

                if (map[y][x] == 'C') {
                    startY = y;
                    startX = x;
                }
            }
        }

        map[startY][startX] = '.';
        System.out.println(bfs(startY, startX) - 1);
    }

    private static int bfs(int y, int x) {
        PriorityQueue<Point> q = new PriorityQueue<>();
        q.add(new Point(y, x, -1, 0));

        visited = new int[h][w][4];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                Arrays.fill(visited[i][j], 987654321);
            }
        }
        int ret = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            Point p = q.poll();

            if (map[p.y][p.x] == 'C') {
                ret = Math.min(ret, p.mirror);
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];
                int next = (p.dir == i) ? p.mirror : p.mirror + 1;

                if (ny < 0 || ny >= h || nx < 0 || nx >= w) continue;
                if (visited[ny][nx][i] < next) continue;
                if (map[ny][nx] == '*') continue;

                if (visited[ny][nx][i] > next) {
                    q.offer(new Point(ny, nx, i, next));
                    visited[ny][nx][i] = next;
                }
            }
        }

        return ret;
    }
}
