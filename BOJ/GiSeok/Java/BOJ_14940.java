/**
 * 14940 - 쉬운 최단거리(S1/BFS) [O|00:17:55]
 * 시도3
 */
package BOJ.GiSeok.Java;

import java.io.*;
import java.util.*;

public class BOJ_14940 {
    static class Pos {
        int x, y;
        public Pos(int y, int x) {this.y=y; this.x=x;}
    }

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayDeque<Pos> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        int[][] map = new int[n][m];
        for (int y = 0; y < n; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < m; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
                if (map[y][x] == 2) {
                    map[y][x] = 0;
                    q.add(new Pos(y, x));
                    visited[y][x] = true;
                }
            }
        }

        while (!q.isEmpty()) {
            Pos p = q.poll();

            for (int i = 0; i < 4; i++) {
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];

                if (ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
                if (visited[ny][nx]) continue;
                if (map[ny][nx] == 0) continue;

                q.add(new Pos(ny, nx));
                visited[ny][nx] = true;
                map[ny][nx] += map[p.y][p.x];
            }
        }

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                if (!visited[y][x] && map[y][x] == 1) System.out.print("-1 ");
                else System.out.print(map[y][x] + " ");
            }
            System.out.println();
        }
    }
}
