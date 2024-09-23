package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1368 {
    static class Edge {
        int i, j, w;

        public Edge(int i, int j, int w) {
            this.i = i;
            this.j = j;
            this.w = w;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "i=" + i +
                    ", j=" + j +
                    ", w=" + w +
                    '}';
        }
    }
    static int N;
    static int[] W;
    static List<Edge> edges = new ArrayList<>();
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        parent = new int[N+1];

        W = new int[N+1];
        for(int i=1; i<=N; i++) {
            parent[i] = i;
            W[i] = Integer.parseInt(br.readLine());
            edges.add(new Edge(0, i, W[i]));
        }

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++) {
                int w = Integer.parseInt(st.nextToken());
                if(i==j) continue;
                edges.add(new Edge(i, j, w));
            }
        }

        edges.sort((a, b) -> a.w - b.w);

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
