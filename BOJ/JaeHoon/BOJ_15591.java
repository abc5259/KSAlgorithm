package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15591 {
    static int N,Q;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static boolean[] isVisited;
    static int answer;
    static class Node {
        int v,w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        isVisited = new boolean[N+1];
        for(int i=0; i<=N; i++) graph.add(new ArrayList<>());

        for(int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(v1).add(new Node(v2,w));
            graph.get(v2).add(new Node(v1,w));
        }

        StringBuffer sb = new StringBuffer();
        for(int i=0; i<Q; i++) {
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            answer = 0;
            Arrays.fill(isVisited,false);
            isVisited[V] = true;
            dfs(V,K,Integer.MAX_VALUE);
            sb.append(answer).append('\n');
        }

        System.out.println(sb);


    }

    public static void dfs(int v, int k, int usado) {

        for(Node next: graph.get(v)) {
            if(!isVisited[next.v]) {
                isVisited[next.v] = true;
                int nextUsado = Math.min(next.w,usado);
                if(nextUsado >= k) answer++;
                dfs(next.v,k,nextUsado);
            }
        }
    }
}
