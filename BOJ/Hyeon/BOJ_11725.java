package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_11725 {
    static int[] parents;
    static ArrayList<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        adj = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        parents = new int[N + 1];

        StringTokenizer st;

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
            adj[v].add(u);
        }

        bfs(1);

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            sb.append(parents[i]).append("\n");
        }
        System.out.print(sb);
    }

    static void bfs(int v) {

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        queue.offer(v);
        parents[v] = v;

        while (!queue.isEmpty()) {
            int poll = queue.poll();

            for (int i : adj[poll]) {
                if (parents[i] == 0) {
                    queue.offer(i);
                    parents[i] = poll;
                }
            }
        }
    }
}
// S2 트리의 부모 찾기 BFS
// 13분
// 일단 parents 라는 방문여부를 따지는 배열이 중요했다 이는 왜냐하면 visit 로 평소에 따져서 boolean 타입으로
// 쓰고 마는데 여기서는 parents의 값은 값의 부모 노드를 기억해야됐기 때문에 int 배열로
// 만들어서 방문여부를 해결한다.