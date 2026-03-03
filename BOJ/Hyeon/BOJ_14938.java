package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_14938 {
    static int n, m;
    static List<Node>[] adj;
    static int[] items;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        items = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        adj = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            adj[from].add(new Node(to, l));
            adj[to].add(new Node(from, l));
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, dijkstra(i));
        }
        System.out.println(max);
    }

    static int dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[n + 1];
        Arrays.fill(dist, 16);

        dist[start] = 0;
        pq.offer(new Node(start, 0));

        int cnt = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.l > dist[cur.v]) {
                continue;
            }

            if (m >= cur.l) {
                cnt += items[cur.v];
            }

            for (Node next : adj[cur.v]) {
                if (cur.l + next.l > m) {
                    continue;
                }
                if (dist[next.v] > cur.l + next.l) {
                    dist[next.v] = cur.l + next.l;
                    pq.offer(new Node(next.v, dist[next.v]));
                }
            }
        }
        return cnt;
    }

    static class Node implements Comparable<Node> {
        int v;
        int l;

        public Node(int v, int l) {
            this.v = v;
            this.l = l;
        }

        @Override
        public int compareTo(Node node) {
            return this.l - node.l;
        }
    }
}
// G4 서강그라운드 다익스트라
// 39분
// trouble shooting
// cnt 에 대한 조건분기가 헷갈렸다 pq 에서 poll 하고나서 이게 수색범위 이내라면
// 그때 item 들을 더해버리면 됐다.
// 일단 다익스트라 관점으로 풀이를 이어나가자면 수색범위 m 제한 이내에서 adj 인접리스트를 통해
// 내가 갈 수 있는 next 노드를 구한다음 그 노드 까지의 현재 최단경로가 현재 가중치 + 노드의 가중치로 비교해서 갱신이 되면
// 값을 갱신하고 pq 에 삽입한다.
// 근데 l 로 값을 가지고 있다. dist로 시작부터 각각의 노드에 가중치를 기록해서 현재 가중치 + 노드가 가진 가중치 연산으로 한다.