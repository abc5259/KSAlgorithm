/**
 * [G5 DFS] MooTube (Silver) - O, 00:55:01
 * 시도 1
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_15591 {

    private static ArrayList<ArrayList<USADO>> videos = new ArrayList<>();
    private static boolean[] visited;
    private static int k, ret = 0;

    static class USADO {
        int v, w;

        public USADO(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) videos.add(new ArrayList<>());

        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            videos.get(v1).add(new USADO(v2, w));
            videos.get(v2).add(new USADO(v1, w));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            ret = 0;
            visited = new boolean[n+1];
            dfs(v, 0);
            sb.append(ret).append("\n");
        }

        System.out.println(sb);
    }

    private static void dfs(int v, int w) {
        if (w >= k) ret++;
        visited[v] = true;

        for (int i = 0; i < videos.get(v).size(); i++) {
            int v2 = videos.get(v).get(i).v;
            int w2 = videos.get(v).get(i).w;

            if (!visited[v2]) {
                dfs(v2, Math.min(w2, w == 0 ? Integer.MAX_VALUE : w));
            }
        }
    }
}
