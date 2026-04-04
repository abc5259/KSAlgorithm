package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_11779_1 {
    static int n, from, to;
    static List<Node>[] adj;
    static int[] cost, tracking;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        adj = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        cost = new int[n + 1];
        tracking = new int[n + 1];

        StringTokenizer st;
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adj[u].add(new Node(v, w));
        }

        st = new StringTokenizer(br.readLine());

        from = Integer.parseInt(st.nextToken());
        to = Integer.parseInt(st.nextToken());

        System.out.println(dijkstra());
        Deque<Integer> stack = new ArrayDeque<>();

        StringBuilder sb = new StringBuilder();

        while (tracking[to] != 0) {
            stack.push(to);
            to = tracking[to];
        }
        stack.push(from);

        sb.append(stack.size()).append("\n");

        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb);
    }

    static int dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[from] = 0;

        Arrays.fill(tracking, -1);
        tracking[from] = 0;

        pq.offer(new Node(from, 0));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.v == to) {
                return cost[to];
            }

            if (cost[cur.v] < cur.w) {
                continue;
            }

            for (Node next : adj[cur.v]) {
                if (cost[next.v] > cur.w + next.w) {
                    cost[next.v] = cur.w + next.w;
                    pq.offer(new Node(next.v, cost[next.v]));
                    tracking[next.v] = cur.v;
                }
            }

        }
        return -1;
    }

    static class Node implements Comparable<Node> {
        int v;
        int w;

        Node(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node node) {
            return this.w - node.w;
        }
    }
}
// G3 최소비용 구하기 2 다익스트라, 역추적 복습
// 20분
// 최소비용 구하기 1 과 같은데 역추적만 더해서 tracking 배열을 만들어서 next.v 의 인덱스 값에 cur.v 를 넣어서
// while 문으로 to 부터 역추적해서 0이 반환되면 시작이니까 그거 감안해서 돌렸다.