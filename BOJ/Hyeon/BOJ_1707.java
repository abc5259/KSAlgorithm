package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1707 {
    static int V;
    static ArrayList<Integer>[] adj;
    static int[] colors;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (K-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            adj = new ArrayList[V + 1];
            colors = new int[V + 1];

            for (int i = 1; i <= V; i++) {
                adj[i] = new ArrayList<>();
            }

            while (E-- > 0) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                adj[u].add(v);
                adj[v].add(u);
            }

            sb.append(solve() ? "YES" : "NO").append("\n");
        }
        System.out.println(sb);
    }

    static boolean solve() {
        for (int i = 1; i <= V; i++) {
            if (colors[i] == 0) {
                if (!bfs(i)) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean bfs(int start) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        colors[start] = 1;

        while (!queue.isEmpty()) {
            int poll = queue.poll();

            for (int next : adj[poll]) {
                if (colors[next] == 0) {
                    queue.offer(next);
                    colors[next] = colors[poll] == 1 ? 2 : 1;
                } else {
                    if (colors[poll] == colors[next]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
// G4 이분 그래프 BFS
// 45분
// 문제를 이해를 20분째 못함
// 그래프의 정점의 집합을 2개로 분할 ex ) 1 - 2 - 3
// 근데 각 집합에 속한 정점끼리 == 1이랑 3을 같은 집합으로 해버리면 1이랑 3은 인접 불가능
// 그러면 집합 A 집합 B 이런식으로 구분하는데 그래프에서 내가 집합A 의정점이라면 나와 인접한 정점은 모두 집합 B가 되어야한다
// 하지만 나와 인접한 정점 중 이미 방문한 정점 중에 같은 집합이 있다면 이분그래프가 불가능한것이다.
// trouble shooting
// 아니 색칠로 이분법으로 적용한다 그냥 1인 애들이랑 2인애들 이거 비교해서 값 리턴하고
// 나는 커넥티드 컴포넌트라고 생각해서 1만 넣어서 했었는데 그냥 반복문을 돌려야했다 모든 정점 기준으로
// 연결되어있지않은 부분을 고려해야 했다.