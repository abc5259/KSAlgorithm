/**
 * [G4 다익스트라] 특정한 최단 경로 - O(반례힌트), 00:40:05
 * 시도7
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_1504 {
    private static class Edge {
        int v, w;

        public Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    private static LinkedList<LinkedList<Edge>> graph = new LinkedList<>();
    private static int[] shortestPath;
    private static boolean[] visited;

    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) graph.add(new LinkedList<>());

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(v1).add(new Edge(v2, w));
            graph.get(v2).add(new Edge(v1, w));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        dijkstra(1);
        int case1 = shortestPath[v1];
        int case2 = shortestPath[v2];

        dijkstra(v1);
        case1 += shortestPath[v2];
        case2 += shortestPath[n];

        dijkstra(v2);
        case1 += shortestPath[n];
        case2 += shortestPath[v1];

        if (case1 >= 200000000 && case2 >= 200000000) {
            System.out.println(-1);
        } else {
            System.out.println(Math.min(case1, case2));
        }
    }

    public static void dijkstra(int v) {
        shortestPath = new int[n+1];
        visited = new boolean[n+1];
        Arrays.fill(shortestPath, 200000000);

        shortestPath[v] = 0;
        for (int tc = 1; tc <= n; tc++) {
            int nextVertex = findNextVertex();
            visited[nextVertex] = true;

            for (int idx = 0; idx < graph.get(nextVertex).size(); idx++) {
                Edge edge = graph.get(nextVertex).get(idx);
                shortestPath[edge.v] = Math.min(shortestPath[nextVertex] + edge.w, shortestPath[edge.v]);
            }
        }
    }

    private static int findNextVertex() {
        int value = Integer.MAX_VALUE;
        int nextVertex = 0;
        for (int vertex = 1; vertex <= n; vertex++) {
            if (shortestPath[vertex] < value && !visited[vertex]) {
                value = shortestPath[vertex];
                nextVertex = vertex;
            }
        }
        return nextVertex;
    }
}
