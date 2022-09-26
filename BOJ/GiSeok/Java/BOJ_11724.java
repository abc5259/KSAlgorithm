/*
백준 - 11724 연결 요소의 개수 (06/02 목)

*/
package BOJ.GiSeok.Java;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

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

        for (int i = 0; i < N + 1; i++) {
            if (graph[v][i] == 1)
                if (!visited[i])
                    dfs(i, N);
        }
    }
}

public class BOJ_11724 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 정점의 개수
        int M = Integer.parseInt(st.nextToken());   // 간선의 개수
        Graph gr = new Graph(N);
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            gr.addEdge(v1, v2);
        }

        int cc = 0;
        for (int i = 1; i < N + 1; i++) {
            if (!gr.visited[i]) {
                gr.dfs(i, N);
                cc++;
            }
        }
        bw.write(cc + "\n");

        bw.flush();
        bw.close();
    }
}