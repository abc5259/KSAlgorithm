/**
 * [S1 DFS] 작업 - O, 00:11:30
 * 시도2
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_21937 {

    private static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    private static boolean[] visited;
    private static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        visited = new boolean[n+1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            graph.get(v2).add(v1);
        }

        int x = Integer.parseInt(br.readLine());
        System.out.println(dfs(x) - 1);
    }

    public static int dfs(int v) {
        visited[v] = true;

        int tmp = 1;
        for (int i = 0; i < graph.get(v).size(); i++) {
            if (!visited[graph.get(v).get(i)]) tmp += dfs(graph.get(v).get(i));
        }
        return tmp;
    }
}
