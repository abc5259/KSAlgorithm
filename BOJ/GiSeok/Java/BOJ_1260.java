/*
백준 - 1260 DFS와 BFS (06/02 목)

*/
package BOJ.GiSeok;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

class Graph {
    public int[][] graph;
    public boolean[] visited;

    Graph(int N) {
        graph = new int[N + 1][N + 1];
        visited = new boolean[N + 1];
    }
    public void addEdge(int n1, int n2) {
            graph[n1][n2] = 1;
            graph[n2][n1] = 1;
    }
    public void dfs(int v, int N) {
        visited[v] = true;
        System.out.print(v + " ");

        for (int i = 0; i < N + 1; i++) {
            if (graph[v][i] == 1)
                if (!visited[i])
                    dfs(i, N);
        }
    }
    public void bfs(int v, int N) {
        Queue<Integer> queue = new LinkedList<>();

        visited[v] = true;
        queue.offer(v);
        while (!queue.isEmpty()) {
            int V = queue.poll();
            System.out.print(V + " ");
            for (int i = 0; i < N + 1; i++) {
                if (graph[V][i] == 1)
                    if (!visited[i]) {
                        visited[i] = true;
                        queue.offer(i);
                    }
            }
        }
    }
}

public class BOJ_1260 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 정점의 개수
        int M = Integer.parseInt(st.nextToken());   // 간선의 개수
        int V = Integer.parseInt(st.nextToken());   // 정점의 번호
        Graph gr = new Graph(N);
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            gr.addEdge(v1, v2);
        }

        gr.dfs(V, N);
        System.out.println("");
        for (int i = 0; i < N + 1; i++)
            gr.visited[i] = false;
        gr.bfs(V, N);
        System.out.println("");
    }
}