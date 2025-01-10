/**
 * [G4 다익스트라] 최단경로 - O, 00:31:14
 * 시도1
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1753 {

    private static class Edge {
        int v, w;

        public Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    private static ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
    private static int[] shortestPath;
    private static boolean[] visited;

    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

        int k = Integer.parseInt(br.readLine());

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(v1).add(new Edge(v2, w));
        }

        dijkstra(k);
        for (int i = 1; i <= n; i++)
            bw.write((shortestPath[i] == Integer.MAX_VALUE ? "INF" : shortestPath[i]) + "\n");

        bw.flush();
        bw.close();
    }


    public static void dijkstra(int v) {
        shortestPath = new int[n+1];
        visited = new boolean[n+1];
        Arrays.fill(shortestPath, Integer.MAX_VALUE);

        shortestPath[v] = 0;
        for (int tc = 1; tc <= n; tc++) {
            int nextVertex = findNextVertex();
            visited[nextVertex] = true;

            for (int idx = 0; idx < graph.get(nextVertex).size(); idx++) {
                Edge edge = graph.get(nextVertex).get(idx);
                if (shortestPath[nextVertex] + edge.w < shortestPath[edge.v])
                    shortestPath[edge.v] = shortestPath[nextVertex] + edge.w;
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
