package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_4386 {
    static int N;
    static class Edge {
        int v1, v2;
        double weight;

        public Edge(int v1, int v2, double weight) {
            this.v1 = v1;
            this.v2 = v2;
            this.weight = weight;
        }
    }
    static class Star {
        double x, y;

        public Star(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }
    static Star[] stars;
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        stars = new Star[N];
        parents = new int[N];
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            stars[i] = new Star(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
            parents[i] = i;
        }

        PriorityQueue<Edge> pq = new PriorityQueue<Edge>((a,b) -> Double.compare(a.weight, b.weight));
        for(int i=0; i<N-1; i++) {
            for(int j=i+1; j<N; j++) {
                double dif = Math.pow(stars[i].x - stars[j].x, 2) + Math.pow(stars[i].y - stars[j].y, 2);
                pq.offer(new Edge(i,j,Math.sqrt(dif)));
            }
        }

        double sum = 0;
        while(!pq.isEmpty()) {
            Edge edge = pq.poll();
            boolean result = union(edge.v1, edge.v2);
            if(result) {
                sum += edge.weight;
            }
        }

        System.out.printf("%.2f\n", sum);
    }

    private static int find(int x) {
        if(parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }

    private static boolean union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a == b) {
            return false;
        }

        if(a<b) {
            parents[b] = a;
        }else {
            parents[a] = b;
        }
        return true;
    }
}
