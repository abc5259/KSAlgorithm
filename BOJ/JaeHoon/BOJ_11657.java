package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11657 {
    static int N,M;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static class Node {
        int v,w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
    static StringBuffer sb = new StringBuffer();
    static long INF = Long.MAX_VALUE - 100000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken()); //도시의 개수
        M = Integer.parseInt(st.nextToken()); //버스노선의 개수

        graph = new ArrayList<>();
        for(int i=0; i<=N; i++) graph.add(new ArrayList<>());

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());
            graph.get(S).add(new Node(E,T));
        }

        bellmanford(1);
        System.out.println(sb);
    }
    public static void bellmanford(int start) {
        long[] dist = new long[N+1];
        Arrays.fill(dist,INF);
        dist[start] = 0;
        boolean update = false;
        for(int i=0; i<N; i++) {
            update = false;
            for(int j=1; j<=N; j++) {
                for(Node next:graph.get(j)) {
                    if(dist[j] != INF && dist[next.v] > dist[j] + next.w) {
                        dist[next.v] = dist[j] + next.w;
                        update = true;
                    }
                }
            }
            if(!update) break;
        }

        boolean[] isMinus = new boolean[N+1];
        if(update) {
            for(int j=1; j<=N; j++) {
                for(Node next:graph.get(j)) {
                    if(dist[j] != INF && dist[next.v] > dist[j] + next.w) {
                        sb.append("-1\n");
                        return;
                    }
                }
            }
        }

        for(int i=2; i<=N; i++) {
            sb.append(dist[i] == INF ? -1 : dist[i]).append("\n");
        }
    }
}
