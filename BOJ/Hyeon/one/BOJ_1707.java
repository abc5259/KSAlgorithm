package BOJ.Hyeon.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1707 {
    static ArrayList<Integer>[] graph;
    static int[] colors;
    static int V, E;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int K = Integer.parseInt(br.readLine());

        while (K-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            graph = new ArrayList[V + 1];
            for (int i = 1; i <= V; i++) {
                graph[i] = new ArrayList<>();
            }

            colors = new int[V + 1];

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                graph[u].add(v);
                graph[v].add(u);
            }

            if (bfs()) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }
        System.out.println(sb);
    }

    static boolean bfs() {
        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 1; i <= V; i++) {
            if (colors[i] != 0) {
                continue;
            }
            colors[i] = 1;
            queue.offer(i);

            while (!queue.isEmpty()) {
                int u = queue.poll();
                for (int v : graph[u]) {
                    if (colors[v] == 0) {
                        colors[v] = 3 - colors[u];
                        queue.offer(v);
                    } else if (colors[v] == colors[u]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}

// G4 이분 그래프 BFS
// 간선 리스트를 활용해야한다 왜냐면 정점의 개수와 간선의 개수가 매우 크기 때문