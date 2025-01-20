/**
 * [G5 우선순위큐|다익스트라] 택배 배송 - O, 00:37:43
 * 시도 6
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_5972 {

    private static class Barn implements Comparable<Barn> {
        int v, w;

        public Barn(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Barn o) {
            return this.w - o.w;
        }
    }

    private static ArrayList<ArrayList<Barn>> graph;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(v1).add(new Barn(v2, w));
            graph.get(v2).add(new Barn(v1, w));
        }

        int ret = dijkstra();
        System.out.println(ret);
    }

    private static int dijkstra() {
        PriorityQueue<Barn> q = new PriorityQueue<>();
        q.add(new Barn(1, 0));

        int[] shortest = new int[n+1];
        for (int i = 0; i <= n; i++) shortest[i] = Integer.MAX_VALUE;
        shortest[1] = 0;

        while (!q.isEmpty()) {
            Barn barn = q.poll();
            if (barn.v == n) return shortest[barn.v];

            for (int idx = 0; idx < graph.get(barn.v).size(); idx++) {
                Barn v2 = graph.get(barn.v).get(idx);

                if (shortest[v2.v] > shortest[barn.v] + v2.w) {
                    q.add(new Barn(v2.v, barn.w + v2.w));
                    shortest[v2.v] = shortest[barn.v] + v2.w;
                }
            }
        }
        return 0;
    }
}
