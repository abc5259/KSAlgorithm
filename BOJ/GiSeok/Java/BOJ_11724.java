package BOJ.GiSeok.Java;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_11724 {
    public static ArrayList<ArrayList<Integer>> gh = new ArrayList<>();
    public static int N, M;
    public static boolean[] visited;

    public static void dfs(int v) {
        visited[v] = true;

        for (int i = 0; i < gh.get(v).size(); i++) {
            if (!visited[gh.get(v).get(i)])
                dfs(gh.get(v).get(i));
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());   // 정점의 개수
        M = Integer.parseInt(st.nextToken());   // 간선의 개수
        
        visited = new boolean[N+1];
        for (int i = 0; i < N+1; i++)
            gh.add(new ArrayList<>());
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            gh.get(v1).add(v2);
            gh.get(v2).add(v1);
        }

        int ans = 0;
        for (int i = 1; i < gh.size(); i++) {
            if (!visited[i]) {
                dfs(i);
                ans++;
            }
        }

        bw.write(ans + "\n");

        bw.flush();
        bw.close();
    }
}