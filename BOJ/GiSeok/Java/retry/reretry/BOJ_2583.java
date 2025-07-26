/**
 * 00:32:15 S1
 */
package BOJ.GiSeok.Java.retry.reretry;

import java.io.*;
import java.util.*;

public class BOJ_2583 {

    private static final int[] dy = {-1, 1, 0, 0};
    private static final int[] dx = {0, 0, -1, 1};

    private static int[][] map;
    private static boolean[][] visited;
    private static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        map = new int[n+1][m+1];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());

            // left down
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());

            // right up
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int y = y1; y < y2; y++) {
                for (int x = x1; x < x2; x++) {
                    map[y][x] = 1;
                }
            }
        }

        int ret = 0;
        List<Integer> ans = new ArrayList<>();
        visited = new boolean[n][m];
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                if (map[y][x] == 1 || visited[y][x]) continue;
                visited[y][x] = true;
                ans.add(dfs(y, x));
                ret++;
            }
        }

        System.out.println(ret);
        Collections.sort(ans);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();
    }

    private static int dfs(int y, int x) {
        int cnt = 1;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny<0||ny>=n||nx<0||nx>=m) continue;
            if (visited[ny][nx]) continue;
            if (map[ny][nx] == 1) continue;

            visited[ny][nx] = true;
            cnt += dfs(ny, nx);
        }

        return cnt;
    }
}
