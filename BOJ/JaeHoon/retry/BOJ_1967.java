package BOJ.JaeHoon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1967 {
    static int N;
    static ArrayList<ArrayList<Node>> tree = new ArrayList<>();
    static class Node {
        int v,w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
    static boolean[] isVisit;
    static long max = 0;
    static int maxNode;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());
        for(int i=0; i<=N; i++) tree.add(new ArrayList<>());
        isVisit = new boolean[N+1];

        for(int i=1; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            tree.get(v1).add(new Node(v2,w));
            tree.get(v2).add(new Node(v1,w));
        }

        dfs(1,0);

        Arrays.fill(isVisit,false);
//        System.out.println(maxNode);
        dfs(maxNode,0);

        System.out.println(max);

    }
    public static void dfs(int node, long dist) {
        isVisit[node] = true;
        if(max < dist) {
            max = dist;
            maxNode = node;
        }

        for(Node next: tree.get(node)) {
            if(isVisit[next.v]) continue;
            dfs(next.v, dist + next.w);
        }
    }
}
