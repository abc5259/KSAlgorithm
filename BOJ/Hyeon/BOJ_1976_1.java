package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1976_1 {
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

        int[] plan = new int[M];
        for (int i = 0; i < M; i++) {
            plan[i] = Integer.parseInt(st.nextToken());
        }
        bfs(plan[0]);

        for (int i = 0; i < M; i++) {
            if (!visit[plan[i]]) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    static void bfs(int start) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        visit[start] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int next : adj[cur]) {
                if (!visit[next]) {
                    queue.offer(next);
                    visit[next] = true;
                }
            }
        }
    }
}
// G4 여행 가자 단일 BFS
// 15분
// 개선된 풀이 여러번 BFS 를 쓰지않게 그냥 plan 배열에 plan[0] 부터 지나간 모든 곳 방문해서
// for 반복문으로 visit 했는지 안했는지 판단만 해도 문제없었다.