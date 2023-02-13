package BOJ.GiSeok.Java;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1976 {
    public static ArrayList<ArrayList<Integer>> gh = new ArrayList<>();
    public static int[] path;
    public static boolean[] visited;
    public static boolean isPassible = true;
    public static int N, M;

    public static void dfs(int v) {
        visited[v] = true;

        for (int i = 0; i < gh.get(v).size(); i++) {
            if (gh.get(v).get(i) == 1 && !visited[i+1])
                dfs(i+1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        path = new int[M];
        visited = new boolean[N+1];

        for (int i = 0; i < N+1; i++)
            gh.add(new ArrayList<>());

        StringTokenizer st;
        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N+1; j++) {
                int v = Integer.parseInt(st.nextToken());
                if (j == i)
                    gh.get(i).add(1);
                else
                    gh.get(i).add(v);
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++)
            path[i] = Integer.parseInt(st.nextToken());

        dfs(path[0]);

        for (int i = 0; i < M; i++) {
            if (!visited[path[i]]) {
                isPassible = false;
                break;
            }
        }
        
        System.out.println(isPassible?"YES":"NO");
    }
}
