/**
 * [G3 플로이드-워샬|브루트포스] 우주 탐사선 - X
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17182 {

    private static int[][] space;
    private static boolean[] visited;
    private static int n, k, ret = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        space = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                space[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int mid = 0; mid < n; mid++) {
            for (int start = 0; start < n; start++) {
                for (int end = 0; end < n; end++) {
                    space[start][end] = Math.min(space[start][end], space[start][mid] + space[mid][end]);
                }
            }
        }

        visited = new boolean[n];
        visited[k] = true;
        dfs(k, 0, 0);
        System.out.println(ret);
    }

    public static void dfs(int start, int sum, int depth) {
        if (depth == n-1) {
            ret = Math.min(ret, sum);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (start == i) continue;
            if (visited[i]) continue;
            visited[i] = true;
            dfs(i, sum + space[start][i], depth + 1);
            visited[i] = false;
        }
    }
}
