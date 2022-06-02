/*
백준 - 1707 이분 그래프 (06/03 금)

*/
package BOJ.GiSeok;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;

class Graph {
    public ArrayList<ArrayList<Integer>> graph;
    public int N;
    public int[] color;

    Graph(int N) {
        graph = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < N + 1; i++)
            graph.add(new ArrayList<Integer>());
        color = new int[N + 1];
    }
    public void addEdge(int n1, int n2) {
            graph.get(n1).add(n2);
            graph.get(n2).add(n1);
    }

    public void dfs(int v, int pre) {
        if (color[pre] == 1)
            color[v] = 2;
        else if (color[pre] == 2)
            color[v] = 1;

        for (int i = 0; i < graph.get(v).size(); i++) {
            int p = graph.get(v).get(i);
            if (color[p] == 0)
                dfs(p, v);
        }

    }

    public String check() {
        for (int i = 1; i < graph.size(); i++) {
            for (int j : graph.get(i))
                if (color[i] == color[j])
                    return "NO\n";
        }
        return "YES\n";
    }
}

public class BOJ_1707 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int K = Integer.parseInt(br.readLine());

        for (int k = 0; k < K; k++) {
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

            gr.color[0] = 1;
            for (int i = 1; i < N + 1; i++)
                if (gr.color[i] == 0)
                    gr.dfs(i, 0);
            bw.write(gr.check());
        }

        bw.flush();
        bw.close();
    }
}