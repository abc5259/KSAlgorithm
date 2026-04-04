package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1916_1 {
    static int N, start, end;
    static List<Node>[] adj;
    static int[] cost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        adj = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        cost = new int[N + 1];

        StringTokenizer st;
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adj[u].add(new Node(v, w));
        }

        st = new StringTokenizer(br.readLine());

        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        System.out.println(dijkstra());
    }

    static int dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Arrays.fill(cost, Integer.MAX_VALUE);
        pq.offer(new Node(start, 0));
        cost[start] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.v == end) {
                return cost[end];
            }

            if (cost[cur.v] < cur.w) {
                continue;
            }

            for (Node next : adj[cur.v]) {
                if (cost[next.v] > cur.w + next.w) {
                    cost[next.v] = cur.w + next.w;
                    pq.offer(new Node(next.v, cost[next.v]));
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
// G5 최소비용 구하기 다익스트라 복습
// 10분
// 일단 풀었다
// 가장 기초적인 다익스트라 개념
// 출발지와 목적지가 주어지기 때문에 출발지 기준으로 갈 수 잇는 각 점의 최단 경로를 구하고 그 최단경로를
// 가중치로 우선순위큐에서 다루기에 가장 먼저 나온 목적지에 도착했을 때의 cost 비용이 최소비용이기에
// 사전 조회로 탈출 조건을 만들고 현재의 가중치가 현재노드의 기록된 가중치보다 클 경우 이는 건너뛴다.