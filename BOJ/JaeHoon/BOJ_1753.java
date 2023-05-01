package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1753 {
    static int V,E;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static class Node {
        int v,w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken()); //정점의 개수
        E = Integer.parseInt(st.nextToken()); //간선의 개수
        dist = new int[V+1];
        for(int i=0; i<=V; i++) {
            graph.add(new ArrayList<>());
        }

        int start = Integer.parseInt(br.readLine()); //시작정점

        for(int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Node(v,w));
        }

        dijkstra(start);
        StringBuffer sb = new StringBuffer();
        for(int i=1; i<=V; i++) {
            sb.append(dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]).append("\n");
        }
        System.out.println(sb);
    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.w - b.w);
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[start] = 0;
        pq.offer(new Node(start,0));

        while(!pq.isEmpty()) {
            Node curr = pq.poll();

            if(curr.w > dist[curr.v]) continue;

            for(Node next: graph.get(curr.v)) {
                if(dist[next.v] > curr.w + next.w) {
                    dist[next.v] = curr.w + next.w;
                    pq.offer(new Node(next.v, dist[next.v]));
                }
            }
        }
    }
}
