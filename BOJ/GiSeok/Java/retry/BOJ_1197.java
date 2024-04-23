package BOJ.GiSeok.Java.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1197 {

    static ArrayList<Edge> edges = new ArrayList<>();
    static int[] set;
    static int V;
    static int E;
    static int w;

    static class Edge {
        int v1;
        int v2;
        int w;

        public Edge(int v1, int v2, int w) {
            this.v1 = v1;
            this.v2 = v2;
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] ve = br.readLine().split(" ");
        V = Integer.parseInt(ve[0]);
        E = Integer.parseInt(ve[1]);
        
        for (int i = 0; i < E; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            edges.add(new Edge(v1, v2, w));
        }

        edges.sort((Edge a, Edge b) -> { return a.w - b.w; });

        set = new int[V+1];
        for (int i = 1; i <= V; i++)
            set[i] = i;

        for (int i = 0; i < E; i++) {
            Edge e = edges.get(i);

            if (find(e.v1) != find(e.v2)) {
                union(e.v1, e.v2);
                w += e.w;
            }
        }

        System.out.println(w);
    }

    static int find(int v) {
        if (v == set[v])
            return v;
        else
            return find(set[v]);
    }

    static void union(int v1, int v2) {
        int pv2 = find(v2);

        set[pv2] = v1;
    }
}
