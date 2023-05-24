package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1976 {
    static int N,M;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());

        parent = new int[N+1];
        for(int i=0; i<=N; i++) parent[i] = i;

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++) {
                int n = Integer.parseInt(st.nextToken());
                if(n == 1) {
                    union(i,j);
                }
            }
        }

        int[] trip = new int[M];
        st = new StringTokenizer(br.readLine());
        boolean isGo = true;
        for(int i=0; i<M; i++) {
            trip[i] = find(Integer.parseInt(st.nextToken()));
            if(i > 0 && trip[i] != trip[i-1]) isGo = false;
        }

        System.out.println(isGo ? "YES" : "NO");


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

    public static boolean isSame(int x, int b) {
        if(find(x) == find(b)) return true;
        return false;
    }
}
