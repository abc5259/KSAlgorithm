package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1005 {
    static int N,K;
    static int[] time;
    static List<List<Integer>> graph;
    static int[] indegree;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            graph = new ArrayList<>();
            for(int i=0; i<=N; i++) graph.add(new ArrayList<>());
            time = new int[N+1];
            indegree = new int[N+1];
            dist = new int[N+1];
            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=N; i++) {
                time[i] = Integer.parseInt(st.nextToken());
            }
            for(int i=0; i<K; i++) {
                st = new StringTokenizer(br.readLine());
                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());
                graph.get(v1).add(v2);
                indegree[v2]++;
            }
            int find = Integer.parseInt(br.readLine());

            Queue<Integer> q = new ArrayDeque<>();
            for(int i=1; i<=N; i++) {
                if(indegree[i] == 0) {
                    dist[i] = time[i];
                    q.offer(i);
                }
            }
            while (!q.isEmpty()) {
                int u = q.poll();
                solve(u, time[u]);
            }
            sb.append(dist[find]).append('\n');
        }
        System.out.print(sb);
    }

    public static void solve(int n, int w) {
        for(int next: graph.get(n)) {
            indegree[next]--;
            dist[next] = Math.max(w + time[next], dist[next]);
            if(indegree[next] != 0) continue;
            solve(next, dist[next]);
        }
    }
}