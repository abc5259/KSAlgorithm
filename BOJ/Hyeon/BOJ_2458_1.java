package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2458_1 {
    static List<Integer>[] adj;
    static boolean[] visit;
    static int[] cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        visit = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj[a].add(b);
        }

        cnt = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(visit, false);
            bfs(i);
        }
        int res = 0;

        for (int i = 1; i <= N; i++) {
            if (cnt[i] == N - 1) {
                res++;
            }
        }
        System.out.println(res);
    }

    static void bfs(int student) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(student);
        visit[student] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int next : adj[cur]) {
                if (!visit[next]) {
                    queue.offer(next);
                    visit[next] = true;

                    cnt[student]++;
                    cnt[next]++;
                }
            }
        }
    }
}
// G4 키 순서 BFS
// cnt 라는 배열이 나보다 작거나 큰 학생의 수를 알아 차리는 용도로 해서 bfs 를 1번만 태워가지고
// 만약 1번이 bfs 를 타면 2,3이 나보다 크다고 치면
// cnt[2] cnt[3] 에 ++ 해준다음 cnt[1] 에도 2번 더한다 왜냐하면 2,3은 나보다 작은애가 1개인거고
// cnt[1]은 나보다 큰애가 2개였기 때문에