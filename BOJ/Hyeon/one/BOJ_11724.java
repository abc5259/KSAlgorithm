package BOJ.Hyeon.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_11724 {
    static int N, M;
    static int[][] graph;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N + 1][N + 1];
        visit = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u][v] = 1;
            graph[v][u] = 1;
        }
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (!visit[i]) {
                bfs(i);
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    static void bfs(int v) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offer(v);
        visit[v] = true;

        while (!queue.isEmpty()) {
            int tmp = queue.poll();
            for (int i = 1; i <= N; i++) {
                if (graph[tmp][i] == 1 && !visit[i]) {
                    queue.offer(i);
                    visit[i] = true;
                }
            }
        }
    }
}

// S2 연결 요소의 개수 BFS
// 일단 풀었다. BFS의 기초