package BOJ.JaeHoon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20040 {
    static int N,M;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N];
        for(int i=0; i<N; i++) parent[i] = i;

        int cnt = 0;
        boolean isCycle = false;
        for(int i=1; i<=M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            int v1Root = find(v1);
            int v2Root = find(v2);

            if(!isCycle && v1Root == v2Root) {
                cnt = i;
                isCycle = true;
            }
            else {
                union(v1,v2);
            }
        }
        System.out.println(cnt);
    }
    public static int find(int x) {
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x != y) {
            if(x <= y) parent[y] = x;
            else parent[x] = y;
        }
    }
}
