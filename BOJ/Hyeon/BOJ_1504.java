package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1504 {
    static int N;
    static List<Node>[] adj;
    static final int INF = 200_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        while (E-- > 0) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            adj[a].add(new Node(b, c));
            adj[b].add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());

        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int[] from1 = dijkstra(1);
        int[] fromV1 = dijkstra(v1);
        int[] fromV2 = dijkstra(v2);

        int path1 = from1[v1] + fromV1[v2] + fromV2[N];
        int path2 = from1[v2] + fromV2[v1] + fromV1[N];

        if (path1 >= INF && path2 >= INF) {
            System.out.println(-1);
        } else {
            System.out.println(Math.min(path1, path2));
        }
    }

    static int[] dijkstra(int start) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);

        queue.offer(new Node(start, 0));
        dist[start] = 0;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if (cur.w > dist[cur.v]) {
                continue;
            }

            for (Node next : adj[cur.v]) {
                if (dist[next.v] > cur.w + next.w) {
                    dist[next.v] = cur.w + next.w;
                    queue.offer(new Node(next.v, dist[next.v]));
                }
            }
        }
        return dist;
    }

    static class Node implements Comparable<Node> {
        int v;
        int w;

        public Node(int p, int w) {
            this.v = p;
            this.w = w;
        }

        @Override
        public int compareTo(Node n) {
            return this.w - n.w;
        }
    }
}
// G4 특정한 최단 경로 다익스트라
// 50분
// 다익스트라의 색다른 풀이 방법
// 갈수 있는 경로에 대해서 1-> v1 -> v2 -> N 과 1-> v2 -> v1 -> N 이렇게 2가지인데 각각의 경로에 대해서 다익스트라를 구해서
// 값으로 접근하면 가능했다.
// 나는 다익스트라 하면서 넣을까 고민이었는데 다익을 여러번 시행해서
// 출발지를 다르게 하고 하면 만약 v1 이 출발지인 다익의 값의 경우 v2 의 cost 비용은 fromV1 배열의 경우 v1 -> v2 의 비용을 얻는다.