/**
 * S1
 */
package BOJ.GiSeok.Java.retry;

import java.io.*;
import java.util.*;

public class BOJ_2468 {
    private static final int[] dy = {-1, 1, 0, 0};
    private static final int[] dx = {0, 0, -1, 1};

    private static int[][] map;
    private static boolean[][] visited;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int y = 0; y < n; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < n; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        int ret = 0;
        for (int i = 1; i <= 100; i++) {
            visited = new boolean[n][n];
            int cnt = 0;
            for (int y = 0; y < n; y++) {
                for (int x = 0; x < n; x++) {
                    if (visited[y][x]) continue;
                    if (map[y][x]<i) continue;
                    dfs(y, x, i);
                    cnt++;
                }
            }

            ret = Math.max(ret, cnt);
        }

        System.out.println(ret);
    }

    private static void dfs(int y, int x, int s) {
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny<0||nx<0||ny>=n||nx>=n) continue;
            if (map[ny][nx]<s) continue;
            if (visited[ny][nx]) continue;

            visited[ny][nx] = true;
            dfs(ny, nx, s);
        }
    }
}
