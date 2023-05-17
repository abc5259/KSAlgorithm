package BOJ.JaeHoon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_11725 {
    static int N;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] isVisit;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        isVisit = new boolean[N+1];
        parent = new int[N+1];

        for(int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }

        dfs(1);

        StringBuffer sb = new StringBuffer();
        for(int i=2; i<=N; i++) {
            sb.append(parent[i]).append("\n");
        }
        System.out.println(sb);
    }
    public static void dfs(int n) {
        isVisit[n] = true;
        for(int nextNode: graph.get(n)) {
            if(isVisit[nextNode]) continue;
            parent[nextNode] = n;
            dfs(nextNode);
        }
    }
}
