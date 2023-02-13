package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class BOJ_1260 {
    public static ArrayList<ArrayList<Integer>> gh = new ArrayList<>();
    public static int N, M, V;
    public static boolean[] visited;

    public static void dfs(int v) {
        visited[v] = true;
        System.out.print(v + " ");

        for (int i = 0; i < gh.get(v).size(); i++) {
            if (!visited[gh.get(v).get(i)])
                dfs(gh.get(v).get(i));
        }
    }

    public static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();

        visited[v] = true;
        queue.offer(v);

        while (!queue.isEmpty()) {
            int q = queue.poll();
            System.out.print(q + " ");

            for (int i = 0; i < gh.get(q).size(); i++) {
                if (!visited[gh.get(q).get(i)]) {
                    visited[gh.get(q).get(i)] = true;
                    queue.offer(gh.get(q).get(i));
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // 정점의 개수
        M = Integer.parseInt(st.nextToken());   // 간선의 개수
        V = Integer.parseInt(st.nextToken());   // 정점의 번호
        
        for (int i = 0; i < N+1; i++) {
            gh.add(new ArrayList<Integer>());
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            gh.get(v1).add(v2);
            gh.get(v2).add(v1);
        }

        visited = new boolean[N+1];
        for (int i = 0; i < gh.size(); i++)
            Collections.sort(gh.get(i));

        dfs(V);
        System.out.println("");

        visited = new boolean[N+1];
        bfs(V);
        System.out.println("");
    }
}