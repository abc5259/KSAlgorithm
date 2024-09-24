package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_10423 {
    static int N, M, K;
    static int[] parent;
    static class Edge {
        int i, j, w;

        public Edge(int i, int j, int w) {
            this.i = i;
            this.j = j;
            this.w = w;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        parent = new int[N+1];
        for(int i=1; i<=N; i++) {
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=K; i++) {
            parent[Integer.parseInt(st.nextToken())] = 0;
        }

        List<Edge> edges = new ArrayList<>();
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges.add(new Edge(a,b,w));
        }
        edges.sort((a,b) -> a.w - b.w);

        int sum = 0;
        for(Edge edge: edges) {
            if(union(edge.i, edge.j)) {
                sum += edge.w;
            }
        }
        System.out.println(sum);
    }

    static int find(int x) {
        if(parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    static boolean union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x == y) return false;

        if(x < y) parent[y] = x;
        else parent[x] = y;

        return true;
    }
}
