package BOJ.GiSeok.Java.retry;

// 00:28:07 G4
import java.util.*;
import java.io.*;

public class BOJ_2636 {

    private static final int[] dy = {-1, 1, 0, 0};
    private static final int[] dx = {0, 0, -1, 1};

    private static int[][] table;
    private static boolean[][] visited;
    private static int n, m;

    public static class Point {
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
        m = Integer.parseInt(st.nextToken());
        table = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;
        int cheeze = 0;
        while (!isDone()) {

            cheeze = countCh();

            visited = new boolean[n][m];
            Deque<Point> q = new ArrayDeque<>();
            q.add(new Point(0, 0));
            visited[0][0] = true;

            while (!q.isEmpty()) {
                Point p = q.poll();

                for (int i = 0; i < 4; i++) {
                    int ny = p.y + dy[i];
                    int nx = p.x + dx[i];

                    if (ny < 0 || ny >= n || nx < 0 || nx >= m) {
                        continue;
                    }
                    if (visited[ny][nx]) {
                        continue;
                    }

                    visited[ny][nx] = true;
                    if (table[ny][nx] == 1) {
                        table[ny][nx] = 0;
                    } else {
                        q.add(new Point(ny, nx));
                    }
                }
            }
            time++;
        }

        System.out.println(time);
        System.out.println(cheeze);
    }

    private static boolean isDone() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (table[i][j] == 1) {
                    return false;
                }
            }
        }

        return true;
    }

    private static int countCh() {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (table[i][j] == 1) {
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
