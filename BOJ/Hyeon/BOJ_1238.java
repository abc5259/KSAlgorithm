package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1238 {
    static int N;
    static final int LIMIT = 100_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        List<Node>[] adj = new ArrayList[N + 1];
        List<Node>[] reverseAdj = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
            reverseAdj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            adj[from].add(new Node(to, time));
            reverseAdj[to].add(new Node(from, time));
        }

        // 각 집에서 파티장 가는걸 O(N) 다익스트라 하지말고 파티에서 집으로 역방향 인접리스트로 하면 1번만 구함
        int[] goParty = dijkstra(reverseAdj, X);

        int[] goHome = dijkstra(adj, X);

        int max = 0;
        for (int i = 1; i <= N; i++) {
            if (goParty[i] + goHome[i] > max) {
                max = goParty[i] + goHome[i];
            }
        }

        System.out.println(max);
    }

    static int[] dijkstra(List<Node>[] graph, int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[N + 1];
        Arrays.fill(dist, LIMIT);

        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.w > dist[cur.v]) {
                continue;
            }

            for (Node next : graph[cur.v]) {
                if (dist[next.v] > cur.w + next.w) {
                    dist[next.v] = cur.w + next.w;
                    pq.offer(new Node(next.v, dist[next.v]));
                }
            }
        }
        return dist;
    }

    static class Node implements Comparable<Node> {
        int v;
        int w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node node) {
            return this.w - node.w;
        }
    }
}
// G3 파티 다익스트라
// 43분
// 기존 풀이 다익스트라 O(N) 번 호출 각 출발지에서 파티장까지
// 일단 가중치 를 통해서 우선순위 정렬을 위해 Node 클래스 빼고 Comparable 구현해서 오름차순 한다음
// 파티장에서 집가는 것을 returning 다익스트라 1번으로 구해서 comeback 배열에 저장해둬서 이를 캐싱
// 집 -> 파티장을 각 출발지로 집을 가져서 N-1 번 반복문 현재노드가 end 일 경우에는 탈출함
// N E log V
// 개선 풀이 다익스트라 딱 2번
// 단방향 간선을 뒤집으면 집에서 파티장 가는것을 파티장에서 집가는거로 구하고 이를 쓸 수 있다.
// 원본 그래프 1개 파티장에서 집 그리고 집에서 파티장을 역방향으로 구해서 2개만 가지면된다.
// 그리고 가장 시간이 오래걸리는 것과 비교하기위헤 max 값 비교