package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1647 {
    static class Edge {
        int v1,v2,w;

        public Edge(final int v1, final int v2, final int w) {
            this.v1 = v1;
            this.v2 = v2;
            this.w = w;
        }
    }
    static int N, M;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N+1];
        for(int i=1; i<=N; i++) {
            parent[i] = i;
        }
        PriorityQueue<Edge> pq = new PriorityQueue<>((a,b) -> {
            return a.w - b.w;
        });
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            Edge e = new Edge(v1, v2, w);
            pq.add(e);
        }

        int max = 0;
        int sum = 0;
        int count = 0;
        while(!pq.isEmpty()) {
            if(count == N-1) break;
            Edge e = pq.poll();
            if (union(e.v1, e.v2)) {
                max = Math.max(max, e.w);
                sum += e.w;
                count++;
            }
        }

        System.out.println(sum - max);
    }

    public static int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    public static boolean union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y) return false;
        if (x < y) parent[y] = x;
        else parent[x] = y;
        return true;
    }
}
