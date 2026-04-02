package BOJ.GiSeok.Java.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1753 {

    static class Edge {
        int des;
        int val;

        public Edge(int des, int val) {
            this.des = des;
            this.val = val;
        }
    }

    static int v, e;
    static int[] dp;
    static Map<Integer, List<Edge>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        graph = new HashMap<>();

        int k = Integer.parseInt(br.readLine()) - 1;

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken())-1;
            int d = Integer.parseInt(st.nextToken())-1;
            int w = Integer.parseInt(st.nextToken());

            List<Edge> list;
            if (graph.containsKey(u)) {
                list = graph.get(u);
            } else {
                list = new ArrayList<>();
            }
            list.add(new Edge(d, w));
            graph.put(u, list);
        }

        dp = new int[v];
        Arrays.fill(dp, 987654321);

        dij(k);

        for (int i = 0; i < v; i++) {
            if (dp[i] == 987654321) System.out.println("INF");
            else System.out.println(dp[i]);
        }
    }

    static void dij(int k) {
        PriorityQueue<Edge> q = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        q.add(new Edge(k, 0));
        dp[k] = 0;

        while (!q.isEmpty()) {
            Edge min = q.poll();

            if (!graph.containsKey(min.des)) continue;

            if (min.val > dp[min.des]) continue;
            for (int i = 0; i < graph.get(min.des).size(); i++) {
                Edge next = graph.get(min.des).get(i);

                if (next.val + min.val < dp[next.des]) {
                    dp[next.des] = next.val + min.val;
                    q.add(new Edge(next.des, dp[next.des]));
                }
            }
        }
    }

    // 시간 초과
//    static void dij(int k) {
//        boolean[] visited = new boolean[v];
//        visited[k] = true;
//        dp[k] = 0;
//
//        while (!isFinish(visited)) {
//            PriorityQueue<Edge> q = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
//            for (int i = 0; i < v; i++) {
//                if (!visited[i]) q.add(new Edge(i, dp[i]));
//            }
//
//            Edge edge = q.poll();
//            visited[edge.des] = true;
//            for (int i = 0; i < graph.get(edge.des).size(); i++) {
//                Edge t = graph.get(edge.des).get(i);
//                if (edge.val + t.val < dp[t.des]) {
//                    dp[t.des] = edge.val + t.val;
//                }
//            }
//        }
//    }
}
