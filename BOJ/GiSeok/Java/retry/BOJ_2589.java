package BOJ.GiSeok.Java.retry;

// 00:15:47 G5

import java.util.*;
import java.io.*;

public class BOJ_2589 {

    private static final int[] dy = {-1, 1, 0, 0};
    private static final int[] dx = {0, 0, -1, 1};

    static class Pair {
        int y, x;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        List<Pair> l = new ArrayList<>();
        int[][] map = new int[h][w];
        for (int i = 0; i < h; i++) {
            String input = br.readLine();
            for (int j = 0; j < w; j++) {
                char ch = input.charAt(j);
                if (ch == 'W') {
                    map[i][j] = 0;
                } else {
                    map[i][j] = 1;
                    l.add(new Pair(i, j));
                }
            }
        }

        int ret = 0;
        for (Pair p : l) {
            int[][] visited = new int[h][w];
            Deque<Pair> q = new ArrayDeque<>();
            q.add(p);
            for (int i = 0; i < h; i++) {
                Arrays.fill(visited[i], 100000);
            }
            visited[p.y][p.x] = 0;

            while (!q.isEmpty()) {
                Pair c = q.poll();

                for (int i = 0; i < 4; i++) {
                    int ny = c.y + dy[i];
                    int nx = c.x + dx[i];

                    if (ny < 0 || ny >= h || nx < 0 || nx >= w) {
                        continue;
                    }
                    if (visited[ny][nx] != 100000) {
                        continue;
                    }
                    if (map[ny][nx] == 0) {
                        continue;
                    }

                    visited[ny][nx] = Math.min(visited[c.y][c.x] + 1, visited[ny][nx]);
                    ret = Math.max(ret, visited[ny][nx]);
                    q.add(new Pair(ny, nx));
                }
            }
        }

        System.out.println(ret);
    }
}
