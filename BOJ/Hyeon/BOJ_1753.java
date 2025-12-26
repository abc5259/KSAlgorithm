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
        Arrays.fill(dist, Integer.MAX_VALUE);

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
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(K, 0));
        dist[K] = 0;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if (cur.w > dist[cur.v]) {
                continue;
            }

            for (Node next : adj[cur.v]) {
                if (dist[next.v] > next.w + cur.w) {
                    dist[next.v] = cur.w + next.w;
                    queue.offer(new Node(next.v, dist[next.v]));
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
// 48분
// 가중치가 다른 최단경로 문제
// trouble shooting
// 그리고 node에 넣을 때 새 가중치로 갱신해서 해야됨
// Integer.MAX_VALUE 와 도 비교하는 탈출문과 현재의 가중치가 더 작을 경우도 탈출 조건으로 사용
