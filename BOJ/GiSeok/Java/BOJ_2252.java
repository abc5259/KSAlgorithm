package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Stack;

public class BOJ_2252 {
    static int N;
    static int M;
    static ArrayList<ArrayList<Integer>> gp = new ArrayList<>();
    static Stack<Integer> stack = new Stack<>();
    static boolean[] visited;

    static void dfs(int v) {
        visited[v] = true;
        
        for (int i = 0; i < gp.get(v).size(); i++) {
            if (!visited[gp.get(v).get(i)])
                dfs(gp.get(v).get(i));
        }

        stack.push(v);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1];

        for (int i = 0; i < N+1; i++)
            gp.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            gp.get(n1).add(n2);
        }

        for (int i = 1; i < N + 1; i++) {
            if (!visited[i])
                dfs(i);
        }

        while (!stack.isEmpty())
            System.out.print(stack.pop() + " ");
        System.out.println();
    }
}
