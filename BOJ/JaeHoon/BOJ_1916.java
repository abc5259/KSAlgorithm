package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1916 {
    static int N,M;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static class Node {
        int v, w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        for(int i=0; i<=N; i++) graph.add(new ArrayList<>());

        for(int i=0; i<M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(v1).add(new Node(v2, w));
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());
        System.out.println(dijkstra(v1, v2));
    }

    private static int dijkstra(int start, int end) {
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.w - b.w);
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if(dist[curr.v] < curr.w) {
                continue;
            }

            for(Node next: graph.get(curr.v)) {
                if(curr.w + next.w < dist[next.v]) {
                    dist[next.v] = curr.w + next.w;
                    pq.offer(new Node(next.v, dist[next.v]));
                }
            }
        }

        return dist[end];
    }
}
