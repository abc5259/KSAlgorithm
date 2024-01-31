package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1238 {
    static class Node {
        int v,t;

        public Node(int v, int t) {
            this.v = v;
            this.t = t;
        }
    }
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static ArrayList<ArrayList<Node>> rGraph = new ArrayList<>();
    static int N,M,X;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        for(int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
            rGraph.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            graph.get(v1).add(new Node(v2, t));
            rGraph.get(v2).add(new Node(v1, t));
        }


        int[] cost1 = dijkstra(graph);
        int[] cost2 = dijkstra(rGraph);

        int answer = 0;
        for(int i=1; i<=N; i++) {
            answer = Math.max(answer, cost1[i] + cost2[i]);
        }

        System.out.println(answer);

    }
    static int[] dijkstra(ArrayList<ArrayList<Node>> graph) {
        int[] cost = new int[N+1];
        Arrays.fill(cost, 10000000);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        pq.offer(new int[]{X,0});
        cost[X] = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();

            if(cost[curr[0]] < curr[1]) continue;

            for(Node next: graph.get(curr[0])) {
                if(cost[next.v] > next.t + curr[1]) {
                    cost[next.v] = next.t + curr[1];
                    pq.offer(new int[]{next.v, cost[next.v]});
                }
            }
        }

        return cost;
    }
}
