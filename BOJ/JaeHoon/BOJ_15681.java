package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15681 {
    static int N,R,Q;
    static List<List<Integer>> tree = new ArrayList<>();
    static int[] memo;
    static boolean[] isVisited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        memo = new int[N+1];
        isVisited = new boolean[N+1];
        for(int i=0; i<=N; i++) tree.add(new ArrayList<>());

        for(int i=1; i<=N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree.get(a).add(b);
            tree.get(b).add(a);
        }
        solve(R);
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=Q; i++) {
            int q = Integer.parseInt(br.readLine());
            sb.append(memo[q]).append('\n');
        }
        System.out.print(sb);
    }

    public static int solve(int node) {
        isVisited[node] = true;
        int cnt = 1;
        for(int next: tree.get(node)) {
            if(isVisited[next]) continue;
            cnt += solve(next);
        }
        memo[node] = cnt;
        return cnt;
    }
}
