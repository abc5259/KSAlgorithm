package BOJ.Hyeon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_1260 {
    static ArrayList<Integer>[] adjList;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // 입력 받고
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        // 인접 리스트 생성
        adjList = new ArrayList[N + 1];

        // 인접 리스트 초기화
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        // 인접 리스트 만들기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            adjList[from].add(to);
            adjList[to].add(from);
        }

        // 인접 리스트 정점 번호로 오름차순 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(adjList[i]);
        }

        // 방문 여부 확인 방법
        visit = new boolean[N + 1];
        dfs(V);
        sb.append("\n");
        visit = new boolean[N + 1];
        bfs(V);
        System.out.println(sb);
    }

    static void dfs(int v) {
        visit[v] = true;

        sb.append(v).append(" ");
        for (Integer i : adjList[v]) {
            if (!visit[i]) {
                dfs(i);
            }
        }
    }

    static void bfs(int v) {
        // bfs 큐를 생성해서 가장 처음 정점을 넣는다.
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offer(v);

        // 방문 여부를 확인하는 boolean 배열을 true로 만든다.
        visit[v] = true;

        while (!queue.isEmpty()) {
            // 큐에 있던것을 빼고나서 출력하면 해당 정점을 수행한것이다.
            int pv = queue.poll();
            sb.append(pv).append(" ");

            for (Integer i : adjList[pv]) {
                if (!visit[i]) {
                    visit[i] = true;
                    queue.offer(i);
                }
            }
        }
    }
}

// S2 DFS BFS 문제

// 쉽게 생각해서 DFS는 깊이 + true로 바궈주고 + 방문여부 확인 후 재귀
// BFS는 큐로 만들어서 처음 노드는 바로 넣어주고 그뒤부터는 비어있는지 확인하고
// 큐에서 poll해서 그친구를 인덱스로 가지는 인접리스트의 노드를 이용해서 방문 여부확인하고 true로 바꿔주고 offer한다.
