package BOJ.Hyeon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class BOJ_1325 {
    static ArrayList<Integer>[] adj;
    static boolean[] visit;
    static int[] res;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        res = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            adj[B].add(A);
        }

        for (int i = 1; i <= N; i++) {
            visit = new boolean[N + 1];
            dfs(i, i);
        }

        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, res[i]);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            if (res[i] == max) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
    }

    static void dfs(int start, int node) {
        visit[node] = true;
        res[start]++;

        for (int next : adj[node]) {
            if (!visit[next]) {
                dfs(start, next);
            }
        }
    }
}
// S1 효율적인 해킹 DFS
// 아니 이게 DFS 로 안풀려 문제가 계속 시간초과 발생해 모든 수를 다 써서도 다 안되네..그래서
// BFS 로 제출했다..