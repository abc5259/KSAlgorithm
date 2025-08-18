package BOJ.GiSeok.Java.retry;

// 00:44:32 G3
import java.util.*;
import java.io.*;

public class BOJ_4179 {

    static int dy[] = {-1, 1, 0, 0};
    static int dx[] = {0, 0, -1, 1};

    static int r, c;
    static int[][] map;

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

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new int[r][c];

        int jy = 0;
        int jx = 0;

        int[][] visited = new int[r][c];
        Deque<Pair> q = new ArrayDeque<>();
        for (int i = 0; i < r; i++) {
            Arrays.fill(visited[i], 987654321);
            String input = br.readLine();
            for (int j = 0; j < input.length(); j++) {
                char what = input.charAt(j);
                if (what == '#') {
                    map[i][j] = 1;
                } else if (what == '.') {
                    map[i][j] = 0;
                } else if (what == 'J') {
                    jy = i;
                    jx = j;
                } else if (what == 'F') {
                    map[i][j] = 3;
                    visited[i][j] = 0;
                    q.add(new Pair(i, j));
                }
            }
        }

        if (jx == 0 || jx == c - 1 || jy == 0 || jy == r - 1) {
            System.out.println("1");
            return;
        }

        while (!q.isEmpty()) {
            Pair p = q.poll();

            for (int i = 0; i < 4; i++) {
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];

                if (ny < 0 || ny >= r || nx < 0 || nx >= c) {
                    continue;
                }
                if (map[ny][nx] == 1) {
                    continue;
                }
                if (visited[p.y][p.x] + 1 >= visited[ny][nx]) {
                    continue;
                }

                visited[ny][nx] = visited[p.y][p.x] + 1;
                q.add(new Pair(ny, nx));
            }
        }

        if (visited[jy][jx] != 0) {
            q.add(new Pair(jy, jx));
            visited[jy][jx] = 0;

            while (!q.isEmpty()) {
                Pair p = q.poll();

                for (int i = 0; i < 4; i++) {
                    int ny = p.y + dy[i];
                    int nx = p.x + dx[i];

                    if (ny < 0 || ny >= r || nx < 0 || nx >= c) {
                        continue;
                    }
                    if (map[ny][nx] == 1) {
                        continue;
                    }
                    if (visited[p.y][p.x] + 1 >= visited[ny][nx]) {
                        continue;
                    }

                    if (ny == 0 || nx == 0 || ny == r - 1 || nx == c - 1) {
                        System.out.println(visited[p.y][p.x] + 1 + 1);
                        System.exit(0);
                    }

                    visited[ny][nx] = visited[p.y][p.x] + 1;
                    q.add(new Pair(ny, nx));
                }
            }
        }

        System.out.println("IMPOSSIBLE");
    }
}
