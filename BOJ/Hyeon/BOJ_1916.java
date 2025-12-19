package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1916 {
    static List<int[]>[] adj;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        adj = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            adj[from].add(new int[]{to, cost});
        }
        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        dijkstra(A, B);
    }

    static void dijkstra(int from, int to) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        queue.offer(new int[]{from, 0});
        dist[from] = 0;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            int curNow = poll[0];
            int curCost = poll[1];

            if (curNow == to) {
                System.out.println(dist[to]);
                return;
            }
            if (curCost > dist[curNow]) {
                continue;
            }

            for (int[] a : adj[curNow]) {
                if (dist[a[0]] > a[1] + curCost) {
                    dist[a[0]] = a[1] + curCost;
                    queue.offer(new int[]{a[0], dist[a[0]]});
                }
            }
        }
    }
}
// G5 최소비용 구하기 다익스트라
// 30분
// 처음 풀어봤다 최소 비용을 구한대서 BFS 인가 했다 그런데 일단 각각 가는 비용이 달랐기에
// 가중치가 다른 최소 거리는 다익스트라 인가보다 하고 풀어봤다
// 가장 주요한 로직은 나와 계속해서 가장가까운 곳을 방문하는 것이다
// 그리고 현재보다 거리가 짧은 곳들은 방문할 생각을 안한다.
// 그래서 adj 의 인덱스를 시작으로 잡고 adj 배열형 리스트에
// 0번 인덱스를 도착지 1번인덱스를 비용으로 잡고 큐는 1번 인덱스 즉 비용이 작은 오름차순으로했다
// 그래서 dist 의 값이 최종 값인데 무한대로 해서 가장 최소비용으로 비교하는거기에  MAX_VALUE 로 초기화하고
// 현재가 도착지라면 탈출하고 현재까지의 이동 비용보다 작으면 넘어간다.