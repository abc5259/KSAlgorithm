package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1753 {
    static int V, K;
    static List<Node>[] adj;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        K = Integer.parseInt(br.readLine());

        adj = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            adj[i] = new ArrayList<>();
        }

        while (E-- > 0) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adj[u].add(new Node(v, w));
        }

        dist = new int[V + 1];

        dijkstra();

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= V; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                sb.append("INF");
            } else {
                sb.append(dist[i]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Arrays.fill(dist, Integer.MAX_VALUE);
        pq.offer(new Node(K, 0));
        dist[K] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (dist[cur.v] < cur.w) {
                continue;
            }

            for (Node next : adj[cur.v]) {
                if (dist[next.v] > cur.w + next.w) {
                    dist[next.v] = cur.w + next.w;
                    pq.offer(new Node(next.v, dist[next.v]));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int v;
        int w;

        Node(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node n) {
            return this.w - n.w;
        }
    }
}
// G4 최단경로 다익스트라
// 22분
// 쉽게 풀었다.
// K에 대해서 출발하는 최단경로고 그래서 V 는 2만 E 는 30만이라서 인접 리스트로 구현했다
// Node class 로 정점과 가중치를 기록하고 가중치 별로 정렬
// 그다음 K에 대해서 최단 경로 구함 dist[현재 정점] 보다 현재 가중치가 크면 바로 건너뛰고
// 작거나 같을 경우 진행해서 갈 수 있는 곳들에 대해 next 를 구하고
// next 의 거리에 대한 값과 이때까지 온 길이 즉 dist[cur.v] 와 next.w 로 대소 비교해서
// 이대로 갱신해서 작성.