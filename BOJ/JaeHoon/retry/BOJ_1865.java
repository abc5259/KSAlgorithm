package BOJ.JaeHoon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1865 {
    static int N,M,W;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static class Node {
        int v,w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
    static int INF = 2000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();
        int TC = Integer.parseInt(st.nextToken());
        while (TC-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); //지점의 개수
            M = Integer.parseInt(st.nextToken()); //도로의 개수
            W = Integer.parseInt(st.nextToken()); //웜홀의 개수

            graph = new ArrayList<>();
            for(int i=0; i<=N; i++) graph.add(new ArrayList<>());

            for(int i=0; i<M; i++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());
                graph.get(S).add(new Node(E,T));
                graph.get(E).add(new Node(S,T));
            }

            for(int i=0; i<W; i++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());
                graph.get(S).add(new Node(E,-T));
            }

            boolean isCycle = false;
            for(int i=1; i<=N; i++) {
                if(bellmanford(i)) {
                    isCycle = true;
                    sb.append("YES\n");
                    break;
                }
            }

            if(!isCycle) sb.append("NO\n");
        }
        System.out.println(sb);
    }
    public static boolean bellmanford(int start) {
        int[] dist = new int[N+1];
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

        if(update) {
            for(int j=1; j<=N; j++) {
                for(Node next:graph.get(j)) {
                    if(dist[j] != INF && dist[next.v] > dist[j] + next.w) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
