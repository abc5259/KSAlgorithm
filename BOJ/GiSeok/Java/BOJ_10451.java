/*
백준 - 10451 순열 그래프 (06/06 월)

*/
package BOJ.GiSeok.Java;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class BOJ_10451 {

    static class Graph {
        public ArrayList<ArrayList<Integer>> graph;
        public boolean[] visited;
        public int N;

        Graph(int N) {
            graph = new ArrayList<ArrayList<Integer>>();
            for (int i = 0; i < N + 1; i++)
                graph.add(new ArrayList<Integer>());
            visited = new boolean[N + 1];
        }

        public void addEdge(int n1, int n2) {
            graph.get(n1).add(n2);
        }

        public void dfs(int v) {
            visited[v] = true;

            for (int i = 0; i < graph.get(v).size(); i++) {
                int p = graph.get(v).get(i);
                if (!visited[p])
                    dfs(p);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            int N = Integer.parseInt(br.readLine());
            Graph gr = new Graph(N);

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int m = 1; m < N + 1; m++)
                gr.addEdge(m, Integer.parseInt(st.nextToken()));
            
            int num = 0;
            for (int j = 1; j < N + 1; j++) {
                if (!gr.visited[j]) {
                    gr.dfs(j);
                    num++;
                }
            }

            bw.write(num + "\n");
        }

        bw.flush();
        bw.close();
    }
}