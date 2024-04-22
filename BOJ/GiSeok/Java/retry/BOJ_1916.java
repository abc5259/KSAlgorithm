package BOJ.GiSeok.Java.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_1916 {
    static class Edge {
        int v1;
        int v2;
        int w;

        Edge(int v1, int v2, int w) {
            this.v1 = v1;
            this.v2 = v2;
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 노드 갯수
        int M = Integer.parseInt(br.readLine()); // 간선 갯수

        ArrayList<Edge> edge = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            String[] edges = br.readLine().split(" ");

            int v1 = Integer.parseInt(edges[0]);
            int v2 = Integer.parseInt(edges[1]);
            int w = Integer.parseInt(edges[2]);

            edge.add(new Edge(v1, v2, w));
        }

        String[] v1v2 = br.readLine().split(" ");
        int startV = Integer.parseInt(v1v2[0]);
        int endV = Integer.parseInt(v1v2[1]);
        int[] route = new int[N + 1];

        for (int i = 1; i <= N; i++)
            route[i] = Integer.MAX_VALUE;

        route[startV] = 0;
        for (int v1 = 1; v1 < N; v1++) {
            for (int i = 0; i < M; i++) {
                Edge e = edge.get(i);

                if (route[e.v1] == Integer.MAX_VALUE) continue;
                if (route[e.v2] > route[e.v1] + e.w)
                    route[e.v2] = route[e.v1] + e.w;
            }
        }

        System.out.println(route[endV]);
    }
}
