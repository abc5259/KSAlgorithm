package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1949 {
    static int[] people;
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] isVisited;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        people = new int[N+1];
        isVisited = new boolean[N+1];
        dp = new int[N+1][2];
        for(int i=1; i<=N; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<=N; i++) graph.add(new ArrayList<>());

        for(int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }

        solve(1);
        System.out.println(Math.max(dp[1][1], dp[1][0]));
    }

    public static void solve(int node) {
        isVisited[node] = true;

        for(int next: graph.get(node)) {
            if(isVisited[next]) continue;
            solve(next);
            dp[node][0] += Math.max(dp[next][0], dp[next][1]);
            dp[node][1] += dp[next][0];
        }

        dp[node][1] += people[node];
    }
}
