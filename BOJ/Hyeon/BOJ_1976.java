package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1976 {
    static int N;
    static List<Integer>[] adj;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        adj = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        visit = new boolean[N + 1];

        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                if (st.nextToken().equals("1")) {
                    adj[i].add(j);
                }
            }
        }

        st = new StringTokenizer(br.readLine());

        int from = Integer.parseInt(st.nextToken());
        for (int i = 1; i < M; i++) {
            int to = Integer.parseInt(st.nextToken());

            if (!bfs(from, to)) {
                System.out.println("NO");
                return;
            }
            from = to;
        }
        System.out.println("YES");
    }

    static boolean bfs(int start, int end) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        Arrays.fill(visit, false);
        visit[start] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur == end) {
                return true;
            }
            for (int next : adj[cur]) {
                if (!visit[next]) {
                    queue.offer(next);
                    visit[next] = true;
                }
            }
        }
        return false;
    }
}
// G4 여행 가자 BFS
// 17분
// 일단 풀었다
// 문제를 읽어봤을 때 주어진 도시에 있어서 내가 갈수있냐 없냐를 판단이라 생각보다 쉬웠다
// EABCBCBD 이런식으로 주어진 값을 내가 구해야되는줄 알았는데 그래서
// 200개의 노드에 1000개의 간선이라 그냥 인접 리스트로 해서 희소 그래프니까
// 그리고 from 과 to를 각각 bfs 태워서 bfs start 가 end를 만나면 이어하고 만약 end 못만나는경우
// 바로 return 빨리해서 값을 내었다. 알고보면 간단한 BFS