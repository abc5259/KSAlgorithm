package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_9370 {
    static int n,m,t,s,g,h;
    static class Node {
        int v,w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    static List<List<Node>> graph;

    static int[] destinations;
    static int d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            graph = new ArrayList<>();
            for(int i=0; i<=n; i++) graph.add(new ArrayList<>());

            for(int i=0; i<m; i++) {
                st = new StringTokenizer(br.readLine());
                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                if(v1 == g && v2 == h) {
                    d = w;
                }
                if(v1 == h && v2 == g) {
                    d = w;
                }
                graph.get(v1).add(new Node(v2,w));
                graph.get(v2).add(new Node(v1,w));
            }

            destinations = new int[t];
            for(int i=0; i<t; i++) destinations[i] = Integer.parseInt(br.readLine());
            Arrays.sort(destinations);

            int[] dist = solve(s);

            if(dist[g] < dist[h]) {

                int[] dist2 = solve(h);
                for(int i=0; i<t; i++) {
                    int destination = destinations[i];

                    if(dist2[destination] == Integer.MAX_VALUE) continue;
                    int total = dist2[destination] + dist[g] + d;

                    if(total == dist[destination]) {
                        sb.append(destination+ " ");
                    }
                }
            }
            else {
                int[] dist2 = solve(g);
                for(int i=0; i<t; i++) {
                    int destination = destinations[i];
                    if(dist2[destination] == Integer.MAX_VALUE) continue;
                    int total = dist2[destination] + dist[h] + d;
                    if(total == dist[destination]) {
                        sb.append(destination+ " ");
                    }
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static int[] solve(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.w - b.w);
        pq.offer(new Node(start, 0));
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if(dist[curr.v] < curr.w) continue;

            for(Node next: graph.get(curr.v)) {
                if(next.w + curr.w < dist[next.v]) {
                    dist[next.v] = next.w +curr.w;
                    pq.offer(new Node(next.v, dist[next.v]));
                }
            }
        }

        return dist;

    }
}
