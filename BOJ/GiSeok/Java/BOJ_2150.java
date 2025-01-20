/**
 * [P5 SCC] Strongly Connected Component - X
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_2150 {

    private static int v;

    private static ArrayList<ArrayList<Integer>> graph;
    private static boolean[] visited;
    private static int[] ids;
    private static int id = 1;

    private static ArrayDeque<Integer> stk = new ArrayDeque<>();
    private static ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= v; i++) graph.add(new ArrayList<>());

        visited = new boolean[v+1];
        ids = new int[v+1];

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            graph.get(v1).add(v2);
        }
        for (int i = 1; i <= v; i++) {
            graph.get(i).add(i);
        }

        for (int i = 1; i <= v; i++) {
            if (ids[i] != 0) continue;
            dfs(i);
        }

        res.sort(new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o1.get(0) - o2.get(0);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (ArrayList list : res) {
            for (int idx = 0; idx < list.size(); idx++) {
                sb.append(list.get(idx)).append(" ");
            }
            sb.append("-1").append("\n");
        }

        System.out.println(res.size());
        System.out.println(sb);
    }

    private static int dfs(int now) {
        ids[now] = id++;
        stk.push(now);

        int parent = ids[now];

        for (int idx = 0; idx < graph.get(now).size(); idx++) {
            int next = graph.get(now).get(idx);
            if (ids[next] == 0) parent = Math.min(parent, dfs(next));
            else if (!visited[next]) parent = Math.min(parent, ids[next]);
        }

        if (parent == ids[now]) {
            ArrayList<Integer> scc = new ArrayList<>();
            while (true) {
                int node = stk.pop();
                ids[node] = parent;
                visited[node] = true;
                scc.add(node);
                if (node == now) break;
            }
            Collections.sort(scc);
            res.add(scc);
        }

        return parent;
    }
}
