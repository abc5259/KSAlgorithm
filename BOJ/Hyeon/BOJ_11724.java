package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_11724 {
    static boolean[] visit;
    static ArrayList<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adj[u].add(v);
            adj[v].add(u);
        }

        visit = new boolean[N + 1];

        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (!visit[i]) {
                bfs(i);
                cnt++;
            }
        }
        System.out.print(cnt);
    }

    static void bfs(int v) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        queue.offer(v);
        visit[v] = true;

        while (!queue.isEmpty()) {
            int tmp = queue.poll();

            for (Integer a : adj[tmp]) {
                if (!visit[a]) {
                    queue.offer(a);
                    visit[a] = true;
                }
            }
        }
    }
}
// S2 연결 요소의 개수 BFS
// 24 분
// BFS 의 가장 간단한 문제
// 일단 컴포넌트 별로 떨어져있기도 했고 생각할 시간이 필요했는데 전체 탐색을 1회하면서
// 방문 여부가 없으면 BFS로 파고 들어서 cnt 의 개수를 늘려주면된다
// bfs 의 메소드의 경우에는 그냥
// 1. offer, visit, while 이 반복이다
// offer 할지 push 할지 고민