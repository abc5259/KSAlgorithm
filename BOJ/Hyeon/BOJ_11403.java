package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_11403 {
    static List<Integer>[] adj;
    static int[][] res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        adj = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }

        res = new int[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    adj[i].add(j);
                }
            }
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            bfs(i);

            for (int val : res[i]) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void bfs(int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int next : adj[cur]) {
                if (res[start][next] == 0) {
                    queue.offer(next);
                    res[start][next] = 1;
                }
            }
        }
    }
}
// S1 경로 찾기 BFS
// 19분
// 가중치가 없다는 점과 또 경로가 있는지 없는지에 대한 여부가 아니라 해당 행에 대해서 갈 수 있는
// 곳을 1로 표시하겠다 이기에 이는 방문여부를 통해서 갈 수 있는지를 점검하기에 BFS 라고 생각
// 주어진 값은 인접 행렬이었지만 나는 인접리스트를 활용해서 1인 좌표의 i와 j 인덱스만 사용하였고
// 이를 통해서 0부터 N까지의 반복문을 통해 해당 row 를 시점으로 큐를 만들어서
// 1이 아닌 이라는 조건을 걸고 방문 여부로 큐를 넣어서 1로 확인을 하는
// 즉 BFS 처럼 풀었다. 이는 커넥티드 컴포넌트 처럼 연결갯수 와 같이 유사하게 풀었다.
// 자기 자신으로 돌아오는 것을 마지막에 순환 그래프가 됐을 때 방문 체크