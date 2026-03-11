package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2458 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer>[] taller = new ArrayList[N + 1];
        List<Integer>[] shorter = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            taller[i] = new ArrayList<>();
            shorter[i] = new ArrayList<>();
        }
        boolean[] visit = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            taller[a].add(b);
            shorter[b].add(a);
        }

        int res = 0;
        for (int i = 1; i <= N; i++) {
            Arrays.fill(visit, false);
            if (bfs(i, taller, visit) + bfs(i, shorter, visit) == N - 1) {
                res++;
            }
        }
        System.out.println(res);
    }

    static int bfs(int student, List<Integer>[] list, boolean[] visit) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(student);
        visit[student] = true;

        int size = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int next : list[cur]) {
                if (!visit[next]) {
                    queue.offer(next);
                    visit[next] = true;
                    size++;
                }
            }
        }
        return size;
    }
}
// G4 키 순서 BFS
// 23분
// 시간복잡도는 N이 500 이고 M이 125000 쯤 되는데 bfs를 2번태우고 O(N) 하니까
// 500 * 125500 해서 시간복잡도가 된다고 생각했다.
// 일단 나보다 작은 학생 수와 큰 학생수의 합이 전체 - 1 과 같다면 내가 몇번째 인지 알 수 있다.
// 그래서 큰애들끼리 연결된것과 작은 애들끼리 연결된것을 고려했다 도달 가능성 확인
// 그리고 이거는 DAG 그래프 할때 인접리스트 시 고려했던건데 반대 방향을 통해서 구하는것을 고려해서
// 큰애와 작은애로 접근했다
// 그래서 BFS 태우고 반복문으로 했다.
// 개선 고려
// 근데 최단경로로도 내가 처음에 고려했었는데 뭐냐면 1번이면 1번이 갈수있는 곳을 최단거리로 표시해두고
// 못간곳은 완화되지 못했을 테니 그게 있다면 안되는 수라고 생각한건데 그러면 이게 BFS 2번 태우는거랑 같다고 생각 왜냐하면
// 양방향 그래프하면 모든곳을 갈 수 있기 때문에