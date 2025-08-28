package BOJ.GiSeok.Java.retry;

// 00:31:51

import java.util.*;
import java.io.*;

public class BOJ_14497 {

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static class Pair {
        int y, x;

        Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Deque<Pair> q = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        int y1 = Integer.parseInt(st.nextToken()) - 1;
        int x1 = Integer.parseInt(st.nextToken()) - 1;
        int y2 = Integer.parseInt(st.nextToken()) - 1;
        int x2 = Integer.parseInt(st.nextToken()) - 1;

        int[][] dom = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                char ch = input.charAt(j);
                if (ch == '#') {
                    dom[i][j] = 1;
                } else if (ch == '*') {
                    dom[i][j] = -1;
                } else {
                    dom[i][j] = ch - '0';
                }
            }
        }

        int ret = 0;
        while (true) {
            visited = new boolean[n][m];
            visited[y1][x1] = true;
            q.add(new Pair(y1, x1));

            while (!q.isEmpty()) {
                Pair p = q.poll();

                for (int i = 0; i < 4; i++) {
                    int ny = p.y + dy[i];
                    int nx = p.x + dx[i];

                    if (ny < 0 || ny >= n || nx < 0 || nx >= m) {
                        continue;
                    }
                    if (visited[ny][nx]) {
                        continue;
                    }
                    if (dom[ny][nx] == -1) {
                        continue;
                    }

                    visited[ny][nx] = true;
                    if (dom[ny][nx] == 1) {
                        dom[ny][nx] = 0;
                    } else {
                        q.add(new Pair(ny, nx));
                    }
                }
            }

            ret++;
            if (visited[y2][x2]) {
                break;
            }
        }

        System.out.println(ret);
    }
}
