/**
 * 21736 - 헌내기는 친구가 필요해(S2/DFS) [O|00:22:29]
 * 시도2
 */
package BOJ.GiSeok.Java;

import java.io.*;
import java.util.*;

public class BOJ_21736 {
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static int n;
    static int m;
    static int[][] map;
    static boolean[][] visited;
    static int ret = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n][m];
        map = new int[n][m];
        int startY = 0;
        int startX = 0;
        for (int i = 0; i < n; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = tmp.charAt(j);
                if (map[i][j] == 'I') {
                    startY = i;
                    startX = j;
                }
            }
        }

        dfs(startY, startX);
        if (ret == 0) System.out.println("TT");
        else System.out.println(ret);

    }

    static void dfs(int y, int x) {
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
            if (visited[ny][nx]) continue;
            if (map[ny][nx] == 'X') continue;
            if (map[ny][nx] == 'P') ret++;

            dfs(ny, nx);
        }
    }
}
