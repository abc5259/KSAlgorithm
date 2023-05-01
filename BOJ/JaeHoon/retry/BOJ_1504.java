package BOJ.JaeHoon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1504 {
    static int N,E;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static int v1,v2;
    static class Node {
        int v,w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
    static int[] dist;
    static int INF = 200000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        dist = new int[N+1];

        for(int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b,c));
            graph.get(b).add(new Node(a,c));
        }

        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        // 1 -> v1 -> v2 -> N
        int dist1 = 0;
        dist1 += dijkstra(1, v1);
        dist1 += dijkstra(v1, v2);
        dist1 += dijkstra(v2, N);

        // 1 -> v2 -> v1 -> N
        int dist2 = 0;
        dist2 += dijkstra(1, v2);
        dist2 += dijkstra(v2, v1);
        dist2 += dijkstra(v1, N);

        int result = (dist1 >= INF && dist2 >= INF) ? -1 : dist1 < dist2 ? dist1 : dist2;
        System.out.println(result);
    }
    public static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.w - b.w);
        Arrays.fill(dist,INF);
        dist[start] = 0;
        pq.offer(new Node(start,0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if(dist[curr.v] < curr.w) continue;

            for(Node next: graph.get(curr.v)) {
                if(dist[next.v] > curr.w + next.w) {
                    dist[next.v] = curr.w + next.w;
                    pq.offer(new Node(next.v,dist[next.v]));

                }
            }
        }
        return dist[end];
    }
}
