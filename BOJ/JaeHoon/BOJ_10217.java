package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_10217 {
    static int N,M,K;
    static List<List<Node>> graph = new ArrayList<>();
    static int[][] dist;
    static class Node {
        int v,c,d;

    public Node(int v, int c, int d) {
        this.v = v;
        this.c = c;
        this.d = d;
    }
}

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            for(int i=0; i<=N; i++) graph.add(new ArrayList<>());
            dist = new int[10001][N+1];
            for(int i=0; i<10001; i++) {
                Arrays.fill(dist[i], Integer.MAX_VALUE);
            }
            for(int i=0; i<K; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                graph.get(u).add(new Node(v, c, d));
            }
            solve();

            int min = Integer.MAX_VALUE;
            for(int i=0; i<=M; i++) {
                min = Math.min(min, dist[i][N]);
            }
            System.out.println(min == Integer.MAX_VALUE ? "Poor KCM" : min);
        }
    }

    public static void solve() {
        for(List<Node> list: graph) {
            list.sort((a,b) -> {
                if(a.d == b.d) return a.c-b.c;
                return a.d - b.d;
            });
        }
        dist[0][1] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> {
            return a.d - b.d;
        });
        pq.offer(new Node(1, 0, 0));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if(dist[cur.c][cur.v] < cur.d) continue;

            for(Node next: graph.get(cur.v)) {
                int cost = cur.c + next.c;
                if(cost > M) continue;
                if(dist[cost][next.v] > cur.d + next.d) {
                    dist[cost][next.v] = cur.d + next.d;
                    pq.offer(new Node(next.v, cur.c + next.c, dist[cost][next.v]));
                }
            }
        }
    }
}
//1
//4 10 4
//1 2 5 3
//2 3 4 4
//3 4 1 5
//1 3 2 8