package BOJ.Hyeon;

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

// S2 너비 우선 탐색 1 알고리즘 수업
// DFS 풀었던 문제와 다른 BFS이다.
// 이때 BFS는 단순하게 만나는 노드를 큐에 족족 넣으며 BFS 큐에 값이 존재할 경우
// 그 값을 poll해서 빼고 그 poll 한 정점이 가지고 있는 인접리스트를 참고하여 방문여부가 없는
// 노드를 큐에 다시 삽입하고 큐가 다빠질 때까지 이를 반복해서
// visit 배열을 통해 순번을 정한다.