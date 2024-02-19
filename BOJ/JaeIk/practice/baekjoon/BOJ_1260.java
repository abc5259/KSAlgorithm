package BOJ.JaeIk.practice.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_1260 {
    static boolean[] bfs_visited;
    static boolean[] dfs_visited;
    static StringBuilder dfs_sb = new StringBuilder();
    static StringBuilder bfs_sb = new StringBuilder();
    static int n, m, v;
    static List<List<Integer>> graph = new ArrayList<>();
    static Stack<Integer> stack = new Stack<>();
    static Queue<Integer> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        dfs_visited = new boolean[n+1];
        bfs_visited = new boolean[n+1];

        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        for(int i=0; i<=n; i++){
            Collections.sort(graph.get(i));
        }

        System.out.println(dfs(v)+"\n"+bfs(v));

    }

    static StringBuilder dfs(int node){
        stack.push(node);
        dfs_visited[node] = true;
        dfs_sb.append(node).append(" ");

        while(!stack.isEmpty()){
            int currentNode = stack.pop();

            for(int i=0; i<graph.get(currentNode).size(); i++){
                int nextNode = graph.get(currentNode).get(i);

                if(!dfs_visited[nextNode]){
                    dfs(nextNode);
                }
            }
        }
        return dfs_sb;
    }

    static StringBuilder bfs(int node){
        queue = new LinkedList<>();
        queue.add(node);
        bfs_visited[node] = true;
        bfs_sb.append(node).append(" ");

        while(!queue.isEmpty()){
            int currentNode = queue.poll();

            for(int i=0; i<graph.get(currentNode).size(); i++){
                int nextNode = graph.get(currentNode).get(i);

                if(!bfs_visited[nextNode]){
                    bfs_visited[nextNode] = true;
                    bfs_sb.append(nextNode).append(" ");
                    queue.add(nextNode);
                }
            }
        }
        return bfs_sb;
    }
}
