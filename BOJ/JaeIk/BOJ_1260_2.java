package BOJ.JaeIk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_1260_2 {
    static boolean[] dfs_visited;
    static Stack<Integer> stack;
    static StringBuilder dfs_sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        int[][] map = new int[n+1][n+1];
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            map[start][end] = 1;
            map[end][start] = 1;
        }

        dfs_sb = new StringBuilder();
        stack = new Stack<>();
        dfs_visited = new boolean[n+1];

        dfs(map, n, v);
        String bfs_sb = bfs(map, n, v);

        System.out.println(dfs_sb+"\n"+bfs_sb);
    }

    static void dfs(int[][] map, int n, int start){
        stack.add(start);
        dfs_visited[start] = true;
        dfs_sb.append(start).append(" ");

        while(!stack.empty()){
            int nowNode = stack.pop();

            for(int i=1; i<=n; i++){
                if(dfs_visited[i])continue;

                if(map[nowNode][i] == 1){
                    dfs(map, n, i);
                }
            }
        }
    }

    static String bfs(int[][] map, int n, int start){
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        queue.add(start);
        visited[start] = true;
        sb.append(start).append(" ");

        while(!queue.isEmpty()){
            int nowNode = queue.poll();

            for(int i=1; i<=n; i++){
                if(visited[i])continue;

                if(map[nowNode][i] == 1){
                    visited[i] = true;
                    queue.add(i);
                    sb.append(i).append(" ");
                }
            }
        }

        return sb.toString();
    }
}
