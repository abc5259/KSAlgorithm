/**
 * [G1 다익스트라+이분탐색] 인터넷 설치 - X
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1800 {

    private static int n, p, k;
    private static ArrayList<ArrayList<Vertex>> graph;

    static class Vertex implements Comparable<Vertex> {
        int v, w;

        public Vertex(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Vertex o) {
            return this.w - o.w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(v1).add(new Vertex(v2, w));
            graph.get(v2).add(new Vertex(v1, w));
        }

        int ans = -1;
        int left = 0;
        int right = 1_000_001;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (dijkstra(mid)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(ans);
    }

    private static boolean dijkstra(int x) {
        PriorityQueue<Vertex> pq = new PriorityQueue<>();
        pq.add(new Vertex(1, 0));

        int[] shortest = new int[n+1];
        Arrays.fill(shortest, Integer.MAX_VALUE);
        shortest[1] = 0;

        while (!pq.isEmpty()) {
            Vertex vertex = pq.poll();

            if (shortest[vertex.v] < vertex.w) continue;
            for (int idx = 0; idx < graph.get(vertex.v).size(); idx++) {
                int nextValue = vertex.w;
                Vertex next = graph.get(vertex.v).get(idx);
                if (next.w > x)
                    nextValue++;
                if (nextValue < shortest[next.v]) {
                    shortest[next.v] = nextValue;
                    pq.add(new Vertex(next.v, nextValue));
                }
            }
        }

        return shortest[n] <= k;
    }
}
