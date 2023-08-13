package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1800 {
    static int N,P,K;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        for(int i=0; i<=N; i++) graph.add(new ArrayList<>());


        int high = Integer.MIN_VALUE;
        for(int i=0; i<P; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(v1).add(new Node(v2,cost));
            graph.get(v2).add(new Node(v1,cost));
            high = Math.max(high,cost);
        }

        int low = -1;
        boolean check = false;
        while (low + 1 < high) {
            int mid = (low + high) / 2;
            if(check(mid)) {
                check = true;
                high = mid;
            }else {
                low = mid;
            }
        }

        System.out.println(check ? high : -1);

    }
    public static boolean check(int target) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.cost - b.cost);
        int[] dist = new int[N+1];
        pq.offer(new Node(1,0));
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[1] = 0;

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if(curr.cost > dist[curr.id]) continue;

            for(Node n: graph.get(curr.id)) {
                int next = n.id;
                int nextCost = curr.cost;

                if(n.cost > target) {
                    nextCost+=1;
                }

                if(nextCost < dist[next]) {
                    dist[next] = nextCost;
                    pq.offer(new Node(next,nextCost));
                }
            }
        }

        return dist[N] <= K;
    }
    static class Node {
        int id,cost;

        public Node(int id, int cost) {
            this.id = id;
            this.cost = cost;
        }
    }
}
