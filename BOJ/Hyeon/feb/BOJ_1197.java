package BOJ.Hyeon.feb;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1197 {
    static ArrayList<Vertex>[] graph;
    static int V, E;
    static boolean[] visit;

    static PriorityQueue<Vertex> pq = new PriorityQueue<>(new Comparator<Vertex>() {
        @Override
        public int compare(Vertex o1, Vertex o2) {
            return o1.c - o2.c;
        }
    });

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());


        graph = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }
        visit = new boolean[V + 1];


        for (int j = 1; j <= E; j++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            graph[v1].add(new Vertex(v2, c1));
            graph[v2].add(new Vertex(v1, c1));
        }
        System.out.println(prim(1));

    }

    static long prim(int start) {
        pq.offer(new Vertex(start, 0));
        long sum = 0;
        while (!pq.isEmpty()) {
            Vertex vertex = pq.poll();
            if (visit[vertex.v]) {
                continue;
            }
            visit[vertex.v] = true;
            sum += vertex.c;

            for (Vertex vertex1 : graph[vertex.v]) {
                if (!visit[vertex1.v]) {
                    pq.offer(vertex1);
                }
            }
        }
        return sum;
    }

    static class Vertex {
        int v, c;

        public Vertex(int v, int c) {
            this.v = v;
            this.c = c;
        }
    }
}

