/**
 * [P4 BFS] 탈옥 - X
 * 시도 18
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_9376 {

    private static int[] dy = {-1, 1, 0, 0};
    private static int[] dx = {0, 0, -1, 1};

    private static char[][] map;
    private static int h, w;

    private static class Point {
        int y, x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            map = new char[h + 2][w + 2];
            for (int i = 0; i < h+2; i++)
                Arrays.fill(map[i], '.');

            Point prisoner1 = null;
            Point prisoner2 = null;
            for (int y = 1; y <= h; y++) {
                String m = br.readLine();
                for (int x = 1; x <= w; x++) {
                    if (m.charAt(x-1) == '$'){
                        if (prisoner1 == null) prisoner1 = new Point(y, x);
                        else prisoner2 = new Point(y, x);
                        continue;
                    }

                    map[y][x] = m.charAt(x-1);
                }
            }

            int[][] helperMap = bfs(new Point(0, 0));
            int[][] prisonerMap1 = bfs(prisoner1);
            int[][] prisonerMap2 = bfs(prisoner2);

            int ret = Integer.MAX_VALUE;
            int sum = 0;
            for (int y = 0; y <= h+1; y++) {
                for (int x = 0; x <= w+1; x++) {
                    sum = helperMap[y][x] + prisonerMap1[y][x] + prisonerMap2[y][x];
                    if (map[y][x] == '#')
                        sum -= 2;
                    if (ret > sum)
                        ret = sum;
                }
            }

            System.out.println(ret);
        }
    }

    public static int[][] bfs(Point p) {
        boolean[][] visited = new boolean[h+2][w+2];
        visited[p.y][p.x] = true;

        ArrayDeque<Point> q = new ArrayDeque<>();
        q.offer(p);

        int[][] copymap = new int[h+2][w+2];
        for (int i = 0; i < copymap.length; i++) {
            Arrays.fill(copymap[i], 1000000);
        }
        copymap[p.y][p.x] = 0;

        while (!q.isEmpty()) {
            Point poll = q.poll();

            for (int i = 0; i < 4; i++) {
                int ny = poll.y + dy[i];
                int nx = poll.x + dx[i];

                if (ny < 0 || ny > h + 1 || nx < 0 || nx > w + 1) continue;
                if (map[ny][nx] == '*' || visited[ny][nx]) continue;

                if (map[ny][nx] == '#') {
                    q.add(new Point(ny, nx));
                    copymap[ny][nx] = copymap[poll.y][poll.x] + 1;
                    visited[ny][nx] = true;
                } else {
                    q.push(new Point(ny, nx));
                    copymap[ny][nx] = copymap[poll.y][poll.x];
                    visited[ny][nx] = true;
                }
            }
        }

        return copymap;
    }
}
