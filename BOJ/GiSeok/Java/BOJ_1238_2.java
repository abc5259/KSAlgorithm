/**
 * [G3 다익스트라] 파티 - O, 00:30:12
 * 시도 1
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_1238_2 {

    private static class Vertex {
        int v, w;

        public Vertex(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        LinkedList<LinkedList<Vertex>> graph1 = new LinkedList<>();
        LinkedList<LinkedList<Vertex>> graph2 = new LinkedList<>();
        for (int i = 0; i < n+1; i++) {
            graph1.add(new LinkedList<>());
            graph2.add(new LinkedList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph1.get(v1).add(new Vertex(v2, w));
            graph2.get(v2).add(new Vertex(v1, w));
        }

        int[] xTov = dijkstra(graph1, x, n);
        int[] vTox = dijkstra(graph2, x, n);

        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) max = Math.max(max, xTov[i] + vTox[i]);
        System.out.println(max);
    }

    private static int[] dijkstra(LinkedList<LinkedList<Vertex>> graph, int v, int n) {
        int[] shortest = new int[n+1];
        Arrays.fill(shortest, 987654321);
        shortest[v] = 0;

        boolean[] visited = new boolean[n+1];

        for (int i = 1; i <= n; i++) {
            int minV = 0;
            int value = Integer.MAX_VALUE;
            for (int j = 1; j <= n; j++) {
                if (value > shortest[j] && !visited[j]) {
                    value = shortest[j];
                    minV = j;
                }
            }

            visited[minV] = true;
            for (Vertex vertex : graph.get(minV)) {
                shortest[vertex.v] = Math.min(shortest[vertex.v], shortest[minV] + vertex.w);
            }
        }

        return shortest;
    }
}
