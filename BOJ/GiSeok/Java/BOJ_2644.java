/**
 * [S2 DFS] 촌수계산 - O, 00:21:33
 * 시도2
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2644 {

    private static boolean[][] graph;
    private static boolean[] visited;
    private static int n;
    private static int p1, p2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new boolean[n + 1][n + 1];
        visited = new boolean[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        p1 = Integer.parseInt(st.nextToken());
        p2 = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            graph[v1][v2] = true;
            graph[v2][v1] = true;
        }

        int ans = dfs(p1, 0);
        System.out.println(ans);
    }

    public static int dfs(int v, int cnt) {
        visited[v] = true;
        if (v == p2) return cnt;

        int tmp = -1;
        for (int i = 1; i <= n; i++) {
            if (graph[v][i] && !visited[i]) {
                tmp = Math.max(dfs(i, cnt+1), tmp);
            }
        }

        return tmp;
    }
}
