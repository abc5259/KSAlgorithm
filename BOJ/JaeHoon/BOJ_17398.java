package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_17398 {
    static int[] parent;
    static int[] group;
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        parent = new int[N+1];
        group = new int[N+1];
        int[][] edge = new int[M+1][2];
        boolean[] isRemove = new boolean[M+1];

        for(int i=1; i<=N; i++) {
            parent[i] = i;
            group[i] = 1;
        }

        for(int i=1; i<=M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            edge[i][0] = v1;
            edge[i][1] = v2;
        }

        Stack<Integer> removeEdge = new Stack<>();
        for(int i=1; i<=Q; i++) {
            int n = Integer.parseInt(br.readLine());
            removeEdge.push(n);
            isRemove[n] = true;
        }

        for(int i=1; i<=M; i++) {
            if(isRemove[i]) continue;
            union(edge[i][0],edge[i][1]);
        }

        long answer = 0;
        while (!removeEdge.isEmpty()) {
            int[] E = edge[removeEdge.pop()];

            int aRoot = find(E[0]);
            int bRoot = find(E[1]);

            if(aRoot != bRoot) {
                answer += (group[aRoot] * group[bRoot]);
                union(E[0],E[1]);
            }
        }
        System.out.println(answer);
    }
    public static int find(int x) {
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x!= y) {
            parent[y] = x;
            group[x] += group[y];
        }
    }
}
