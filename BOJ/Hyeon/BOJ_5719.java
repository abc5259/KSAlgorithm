package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_5719 {
    static int N;
    static List<Node>[] adj;
    static List<Node>[] reverseAdj;
    static int[] dist;
    static boolean[][] delete;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            if (N == 0 && M == 0) {
                break;
            }

            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            adj = new ArrayList[N];
            reverseAdj = new ArrayList[N];
            delete = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                adj[i] = new ArrayList<>();
                reverseAdj[i] = new ArrayList<>();
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());

                int U = Integer.parseInt(st.nextToken());
                int V = Integer.parseInt(st.nextToken());
                int P = Integer.parseInt(st.nextToken());

                adj[U].add(new Node(V, P));
                reverseAdj[V].add(new Node(U, P));
            }

            dijkstra(start);

            removeBFS(start, end);

            dijkstra(start);

            if (dist[end] == 10_000_000) {
                sb.append(-1);
            } else {
                sb.append(dist[end]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist = new int[N];
        Arrays.fill(dist, 10_000_000);

        dist[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (dist[cur.v] < cur.w) {
                continue;
            }

            for (Node next : adj[cur.v]) {
                if (delete[cur.v][next.v]) {
                    continue;
                }
                if (dist[next.v] > cur.w + next.w) {
                    dist[next.v] = cur.w + next.w;
                    pq.offer(new Node(next.v, dist[next.v]));
                }
            }
        }
    }

    static void removeBFS(int start, int end) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(end);

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            if (cur == start) {
                continue;
            }

            for (Node prev : reverseAdj[cur]) {
                if (dist[prev.v] + prev.w == dist[cur]) {
                    if (delete[prev.v][cur]) {
                        continue;
                    }
                    delete[prev.v][cur] = true;
                    queue.offer(prev.v);
                }
            }
        }
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
// P5 거의 최단 경로 다익스트라
// 30분
// 문제 이해가 오래걸렸는데 그냥 어찌저찌 다익스트라였고
// 풀이 과정은 최단거리에 포함되는 간선을 배제한 채로 최단거리를 구해서 진짜 최단경로가 아닌 거의 인셈이다
// 그래가지고 dijkstra 를 먼저 돌려서 최단경로에 대해서 구한다음
// start 와 end 를 가지고 역으로 추적해서 reverseAdj 를 통해서 prev 의 노드로 진행하고
// 이때 dist[prev.v] + prev.w 가 dist[cur] 과 같다면 이 경로는 최단경로에 포함되어있는 간선이다
// 이를 통해서 delete 하는 N*N 간선으로 만든다음에 다시 dijkstra 돌려서 이 2차원 배열에 포함되지않는채로 구한다.