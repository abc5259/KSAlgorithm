package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_10282 {
    static class Node {
        int v,w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
    static int N, D, C;
    static List<List<Node>> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            graph = new ArrayList<>();
            for(int i=0; i<=N; i++) graph.add(new ArrayList<>());

            for(int i=0; i<D; i++) {
                st = new StringTokenizer(br.readLine());
                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());

                graph.get(v2).add(new Node(v1,w));
            }

            int[] dist = solve();


            int max = 0;
            int cnt = 0;
            for(int i=1; i<=N; i++) {
                if(dist[i] == Integer.MAX_VALUE) continue;
                cnt++;
                max = Math.max(max, dist[i]);
            }

            sb.append(cnt + " " + max).append("\n");

        }
        System.out.println(sb);
    }

    public static int[] solve() {
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.w - b.w);
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[C] = 0;
        pq.offer(new Node(C, 0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if(dist[curr.v] < curr.w) continue;

            for(Node next: graph.get(curr.v)) {
                if(dist[next.v] > curr.w + next.w) {
                    dist[next.v] = curr.w + next.w;
                    pq.offer(new Node(next.v, dist[next.v]));
                }
            }
        }
        return dist;
    }
}
