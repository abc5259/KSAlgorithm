package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_9372 {
    static List<Integer>[] adj;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            adj = new ArrayList[N + 1];
            visit = new boolean[N + 1];

            for (int i = 1; i <= N; i++) {
                adj[i] = new ArrayList<>();
            }

            while (M-- > 0) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                adj[a].add(b);
                adj[b].add(a);
            }
            sb.append(bfs()).append("\n");
        }
        System.out.println(sb);
    }

    static int bfs() {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        visit[1] = true;

        int edges = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int next : adj[cur]) {
                if (!visit[next]) {
                    visit[next] = true;
                    queue.offer(next);
                    edges++;
                }
            }
        }
        return edges;
    }
}
// S4 상근이의 여행 BFS
// 10분
// 그냥 방문여부로 판단해서 풀었다.