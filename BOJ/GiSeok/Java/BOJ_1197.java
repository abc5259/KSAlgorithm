// MST - boj.kr/1197 최소 스패닝 트리
package BOJ.GiSeok.Java;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class BOJ_1197 {

    static class Edge implements Comparable<Edge> {
        int v;
        int weight;

        Edge(int v, int w) {
            this.v = v;
            weight = w;
        }

        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.weight, o.weight);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[V+1];
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < V+1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(v1).add(new Edge(v2, w));
            graph.get(v2).add(new Edge(v1, w));
        }

        PriorityQueue<Edge> q = new PriorityQueue<>();
        q.add(new Edge(1, 0));

        int ans = 0;
        while (!q.isEmpty()) {
            Edge a = q.remove();

            if (visited[a.v]) continue;
            else {
                visited[a.v] = true;

                for (Edge e : graph.get(a.v))
                    q.add(e);
                
                ans += a.weight;
            }
        }

        System.out.println(ans);
    }
}