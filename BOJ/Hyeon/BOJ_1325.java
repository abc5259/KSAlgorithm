package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1325 {
    static int N;
    static ArrayList<Integer>[] adj;
    static int[] cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        cnt = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            adj[B].add(A);
        }

        int max = 0;
        for (int i = 1; i <= N; i++) {
            bfs(i);
            max = Math.max(max, cnt[i]);
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            if (max == cnt[i]) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
    }

    static void bfs(int num) {
        boolean[] visit = new boolean[N + 1];
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offer(num);
        visit[num] = true;

        while (!queue.isEmpty()) {
            int poll = queue.poll();

            for (int next : adj[poll]) {
                if (!visit[next]) {
                    queue.offer(next);
                    visit[next] = true;
                    cnt[num]++;
                }
            }
        }
    }
}
// S1 효율적인 해킹 BFS
// 15분
// 일단 가장 많은 컴퓨터의 수를 구한다 즉 연결되어있는 가장 많은 수 커넥티드 컴포넌트 에 따라
// DFS BFS 모두 가능한 문제라고 접근 그런데 가중치가 1이다 그러니까 플러드 필로 풀 수 있음
// 그런데 N이 10000 이고 M이 10만이다 이는 N * N 의 행렬보다 인접 리스트를 통해서 희소 간선을 쓰는게 더 효율적이고
// 각 반복문을 돌려서 컴퓨터의 넘버마다 cnt 배열에 값을 저장하고 최대값을 구한다음
// 그 최대값과 비교해서 오름차순으로 컴퓨터의 번호를 추적한다
// 해당 컴퓨터의 넘버마다 방문 여부를 초기화 하기에 bfs 내부에 방문 여부 배열을 넣는다.
// 고민은 cnt 라는 값을 반환하는 BFS 의 역할이 충분한가 고민이다
// 그래서 그냥 메소드 영역에 있는 배열에 직접 접근하며 증감식으로 연산.