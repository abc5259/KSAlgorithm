package BOJ.Hyeon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_24444 {
    static ArrayList<Integer>[] adjList;
    static int[] visit;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adjList[u].add(v);
            adjList[v].add(u);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(adjList[i]);
        }

        visit = new int[N + 1];
        bfs(R);
        for (int i = 1; i <= N; i++) {
            sb.append(visit[i]).append("\n");
        }
        System.out.println(sb);
    }

    static int cnt = 1;

    static void bfs(int v) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        visit[v] = cnt++;
        queue.offer(v);

        while (!queue.isEmpty()) {
            int vs = queue.poll();
            for (Integer i : adjList[vs]) {
                if (visit[i] == 0) {
                    visit[i] = cnt++;
                    queue.offer(i);
                }
            }
        }
    }
}
