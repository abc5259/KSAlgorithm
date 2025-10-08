package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_18352 {
    static ArrayList<Integer>[] adj;
    static int K;
    static int[] cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        cnt = new int[N + 1];
        Arrays.fill(cnt, -1);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            adj[A].add(B);
        }
        pq = new PriorityQueue<>();
        bfs(X);

        StringBuilder sb = new StringBuilder();
        if (pq.isEmpty()) {
            System.out.print(-1);
            return;
        } else {
            while (!pq.isEmpty()) {
                sb.append(pq.poll()).append("\n");
            }
        }
        System.out.println(sb);
    }

    static PriorityQueue<Integer> pq;

    static void bfs(int start) {
        Deque<Integer> queue = new ArrayDeque<>();

        queue.offer(start);
        cnt[start] = 0;

        while (!queue.isEmpty()) {
            int poll = queue.poll();

            if (cnt[poll] == K) {
                pq.offer(poll);
            }
            for (int num : adj[poll]) {
                if (cnt[num] != -1) {
                    continue;
                }
                queue.offer(num);
                cnt[num] = cnt[poll] + 1;
            }
        }
    }
}
// S2 특정 거리의 도시 찾기 BFS
// 20분
// 그냥 쉽게 풀었다
// 시키는대로 반복하는 문제 그자체
// 인접 리스트를 통해 접근하고 단방향에다가 cnt 로 방문 여부 및 노드 거리도 알 수 있엇다.